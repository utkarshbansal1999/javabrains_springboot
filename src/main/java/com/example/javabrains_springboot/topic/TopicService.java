package com.example.javabrains_springboot.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

//    List<Topic> ratings= new ArrayList<>(Arrays.asList(
//            new Topic("12","java","java"),
//            new Topic("13","python","python")
//    ));

    @Autowired
    private TopicRepo topicRepo;

    public List<Topic> getAllTopics() {
        List<Topic> topics=new ArrayList<>();
        topicRepo.findAll().forEach(topics::add);
        return topics;
        //return ratings;
    }

    public Optional<Topic> getTopic(String topicid) {
        return topicRepo.findById(topicid);
        //return ratings.stream().filter(topic -> topic.getId().equals(topicid)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topicRepo.save(topic);
        //ratings.add(topic);
    }


    public void updateTopic(Topic topic, String topicid) {

        topicRepo.save(topic);
//        for(int i=0;i<ratings.size();i++)
//        {
//            if(ratings.get(i).getId().equals(topicid))
//            {
//                ratings.set(i,topic);
//                return ;
//            }
//        }
    }

    public void deleteTopic(String topicid) {
        topicRepo.deleteById(topicid);
        //ratings.removeIf(topic -> topic.getId().equals(topicid));
    }
}
