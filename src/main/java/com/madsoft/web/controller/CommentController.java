package com.madsoft.web.controller;

import com.madsoft.web.form.CommentForm;
import com.madsoft.web.model.Comment;
import com.madsoft.web.service.IPostService;
import com.madsoft.web.form.validator.CommentValidator;
import com.madsoft.web.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class CommentController {

    @Autowired
    private CommentValidator commentValidator;

    @Autowired
    private ICommentService commentService;

    @Autowired
    private IPostService postService;

/*    // list comments
    //@PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = {"/comments"}, method = RequestMethod.GET)

    public String showAllComments(Model model) {

        model.addAttribute("comments", commentService.findAllComments());
        return "comments/list";

    }*/


    // show comment
    @RequestMapping(value = "/comments/{id}", method = RequestMethod.GET)

    public String showComment(@PathVariable("id") int id, Model model) {

        Comment comment = commentService.getComment(id);
        if (comment == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "Comment not found");
        }
        model.addAttribute("comment", comment);

        return "comments/show";

    }


    // show add form
    @RequestMapping(value = "/comments/add", method = RequestMethod.GET)
    public String showAddCommentForm(Model model) {

        CommentForm commentForm = new CommentForm();

        // set default value
        commentForm.setName("имя");
        commentForm.setEmail("email");
        commentForm.setText("комментарий");

        model.addAttribute("commentForm", commentForm);

        return "comments/commentform";

    }


    // delete comment
    @RequestMapping(value = "/comments/{id}/delete", method = RequestMethod.GET)
    public String deleteComment(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

        Comment comment = commentService.getComment(id);
        commentService.deleteComment(comment, postService.getPost(comment.getPostid()));

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Комментарий удален!");

        return "redirect:/posts/" + comment.getPostid();

    }


    // save
    @RequestMapping(value = "/comments/save", method = RequestMethod.POST)
    public String saveComment(@ModelAttribute("commentForm") @Validated CommentForm commentForm,
                              BindingResult result, Model model,
                              final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {

            return "comments/commentform";

        } else {

            Integer postId = commentForm.getPostid();

            System.out.println("commentForm.postId=" + postId);

            if (postId != null) {
                commentService.addComment(commentForm);
            } else {
                //commentService.updateComment(commentService.getComment(commentId), commentForm);
            }

            return "redirect:/posts/" + postId + "#comments";
        }
    }

}

