package com.madsoft.web.controller;

import com.madsoft.web.form.CommentForm;
import com.madsoft.web.form.PostForm;
import com.madsoft.web.form.validator.PostValidator;
import com.madsoft.web.model.Post;
import com.madsoft.web.service.ICommentService;
import com.madsoft.web.service.IPostService;

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
public class PostController {

    @Autowired
    private PostValidator postValidator;

    @Autowired
    private IPostService postService;

    @Autowired
    private ICommentService commentService;

    /*public PostController() {
        this.postService = postService;
    }*/


    // list posts
    //@PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = {"/main", "/posts"}, method = RequestMethod.GET)

    public String showAllPosts(Model model) {

        model.addAttribute("posts", postService.findAllPosts());
        return "posts/list";

    }

    // show post
    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public String showPost(@PathVariable("id") int id, Model model) {//@PathVariable String id

        Post post = postService.getPost(id);
        if (post == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "Post not found");
        }
        model.addAttribute("post", post);

        model.addAttribute("comments", commentService.getCommentsByPostId(id));
        model.addAttribute("commentForm", new CommentForm());

        return "posts/show";

    }


    // show add form
    @RequestMapping(value = "/posts/add", method = RequestMethod.GET)
    public String showAddPostForm(Model model) {

        PostForm postForm = new PostForm();

        // set default value
        postForm.setTitle("Новый пост");
        postForm.setText("Текст поста");
        postForm.setTags("Теги");

        model.addAttribute("postForm", postForm);

        return "posts/postform";

    }

    // show update form
    @RequestMapping(value = "/posts/{id}/update", method = RequestMethod.GET)
    public String showUpdatePostForm(@PathVariable("id") int id, Model model) {

        Post post = postService.getPost(id);
        model.addAttribute("postForm", post);

        return "posts/postform";

    }

    // delete post
    @RequestMapping(value = "/posts/{id}/delete", method = RequestMethod.GET)
    public String deletePost(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

        postService.deletePost(postService.getPost(id));

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Post is deleted!");

        return "redirect:/posts";

    }


    // save
    @RequestMapping(value = "/posts/save", method = RequestMethod.POST)

    public String savePost(@ModelAttribute("postForm") @Validated PostForm postForm,
                           BindingResult result, Model model,
                           final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {

            return "posts/postform";

        } else {

            Integer postId = postForm.getId();
            System.out.println("postForm.getId=" + postId);

            if (postId == null) {
                postId = postService.addPost(postForm);
            } else {
                postService.updatePost(postService.getPost(postId), postForm);
            }

            return "redirect:/posts/" + postId;
        }
    }

}

