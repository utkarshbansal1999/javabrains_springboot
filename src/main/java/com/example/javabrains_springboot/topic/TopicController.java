package com.example.javabrains_springboot.topic;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    List<Topic> ratings= new ArrayList<>(Arrays.asList(
            new Topic("12","java","java"),
            new Topic("13","python","python")
    ));

    @GetMapping("/topics")
    public List<Topic> getTopics()
    {
        return ratings;
    }

    @RequestMapping("/topics/{topicid}")
    public Topic getATopic(@PathVariable(value = "topicid") String topicid)
    {
        return ratings.stream().filter(topic -> topic.getId().equals(topicid)).findFirst().get();
    }

    @RequestMapping(method = RequestMethod.POST,value="/topics")
    public void addTopic(@RequestBody Topic topic)
    {
        ratings.add(topic);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/topics/{topicid}")
    public void updateTopic(@RequestBody Topic topic,@PathVariable(value = "topicid") String topicid)
    {
        for(int i=0;i<ratings.size();i++)
        {
            if(ratings.get(i).getId().equals(topicid))
            {
                ratings.set(i,topic);
                return ;
            }
        }
    }

    @RequestMapping(method=RequestMethod.DELETE,value="/topics/{topicid}")
    public void deleteTopic(@PathVariable(value = "topicid") String topicid)
    {
        ratings.removeIf(topic -> topic.getId().equals(topicid));
    }
}
