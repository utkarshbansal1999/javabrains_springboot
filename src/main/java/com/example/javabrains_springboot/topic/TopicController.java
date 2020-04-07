package com.example.javabrains_springboot.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {

//    List<Topic> ratings= new ArrayList<>(Arrays.asList(
//            new Topic("12","java","java"),
//            new Topic("13","python","python")
//    ));

    @Autowired
    private TopicService topicService;

    @GetMapping("/topics")
    public List<Topic> getTopics()
    {
        return topicService.getAllTopics();
        //return ratings;
    }

    @GetMapping("/topics/{topicid}")
    public Optional<Topic> getTopics(@PathVariable(value = "topicid") String topicid)
    {
        return topicService.getTopic(topicid);
        //return ratings.stream().filter(topic -> topic.getId().equals(topicid)).findFirst().get();
    }

    @RequestMapping(method = RequestMethod.POST,value="/topics")
    public void addTopic(@RequestBody Topic topic)
    {
        topicService.addTopic(topic);
        //ratings.add(topic);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/topics/{topicid}")
    public void updateTopic(@RequestBody Topic topic,@PathVariable(value = "topicid") String topicid)
    {
        topicService.updateTopic(topic,topicid);
//        for(int i=0;i<ratings.size();i++)
//        {
//            if(ratings.get(i).getId().equals(topicid))
//            {
//                ratings.set(i,topic);
//                return ;
//            }
//        }
    }

    @RequestMapping(method=RequestMethod.DELETE,value="/topics/{topicid}")
    public void deleteTopic(@PathVariable(value = "topicid") String topicid)
    {
        topicService.deleteTopic(topicid);
        //ratings.removeIf(topic -> topic.getId().equals(topicid));
    }
}
