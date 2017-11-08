package com.hendisantika.youtubedemo.controller;

import com.hendisantika.youtubedemo.model.YouTubeVideo;
import com.hendisantika.youtubedemo.model.YouTubeSearchCriteria;
import com.hendisantika.youtubedemo.service.YouTubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
/**
 * Created by IntelliJ IDEA.
 * Project : candidate-app
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/11/17
 * Time: 04.15
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class YouTubeDemoController {
	
    @Autowired
    private YouTubeService youtubeService;
    
    
    //starting page for YouTube api demo
    @RequestMapping(value = "/youtubeDemo", method=RequestMethod.GET)
    public String youtubeDemo(Model model) {
        //instantiate an empty address object
        YouTubeSearchCriteria youtubeSearchCriteria = new YouTubeSearchCriteria();
    	
        //put the object in the model
        model.addAttribute("youtubeSearchCriteria", youtubeSearchCriteria);
    	
        //get out
        return "youtubeDemo";
    }
    
    
    @RequestMapping(value = "/youtubeDemo", method=RequestMethod.POST)
    public String formSubmit(@Valid YouTubeSearchCriteria youtubeSearchCriteria, BindingResult bindingResult, Model model) {
        //check for errors
        if (bindingResult.hasErrors()) {
            return "youtubeDemo";
        }
    	
        //get the list of YouTube videos that match the search term
        List<YouTubeVideo> videos = youtubeService.fetchVideosByQuery(youtubeSearchCriteria.getQueryTerm());
    	
        if (videos != null && videos.size() > 0) {
            model.addAttribute("numberOfVideos", videos.size());
        } else {
            model.addAttribute("numberOfVideos", 0);
        }
    	
        //put it in the model
        model.addAttribute("videos", videos);
    	
        //add the criteria to the model as well
        model.addAttribute("youtubeSearchCriteria", youtubeSearchCriteria);
    	
        //get out
        return "showYoutubeResults";
    }
    	
    
    //redirect to demo if user hits the root
    @RequestMapping("/")
    public String home(Model model) {
        return "redirect:youtubeDemo";
    }
}