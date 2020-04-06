package com.example.javabrains_springboot.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    List<Topic> ratings= new ArrayList<>(Arrays.asList(
            new Topic("12","java","java"),
            new Topic("13","python","python")
    ));

    public List<Topic> getAllTopics() {
        return ratings;
    }

    public Topic getTopic(String topicid) {
        return ratings.stream().filter(topic -> topic.getId().equals(topicid)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        ratings.add(topic);
    }


    public void updateTopic(Topic topic, String topicid) {
        for(int i=0;i<ratings.size();i++)
        {
            if(ratings.get(i).getId().equals(topicid))
            {
                ratings.set(i,topic);
                return ;
            }
        }
    }

    public void deleteTopic(String topicid) {
        ratings.removeIf(topic -> topic.getId().equals(topicid));
    }
}
