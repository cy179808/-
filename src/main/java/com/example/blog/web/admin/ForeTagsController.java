package com.example.blog.web.admin;

import com.example.blog.pojo.Blog;
import com.example.blog.pojo.Tag;
import com.example.blog.service.BlogService;
import com.example.blog.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ForeTagsController {

    @Autowired
    private TagsService tagsService;
    @Autowired
    private BlogService blogService;

    @GetMapping("/tags/{id}")
    public String types(@PageableDefault(size = 8, sort = "updateDate", direction = Sort.Direction.DESC) Pageable pageable
            , @PathVariable long id, Model model) {
        List<Tag> tags = tagsService.listTagsTop(10000);
        if (id == -1) {
            id = tags.get(0).getId();
        }
        Page<Blog> blogs = blogService.listBlogByTagId(pageable, id);
        model.addAttribute("tags", tags);
        model.addAttribute("blogs", blogs);
        model.addAttribute("activeId", id);
        model.addAttribute("page", blogs);
        return "tags";
    }

}
