package org.magnum.dataup.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.magnum.dataup.model.Video;

public class VideoUtil {

    private static Map<Long, Video> videoMap = new HashMap<Long, Video>();

    public static Video addVideo(Video video) {

        if (video.getId() == 0 || videoMap.containsKey(video.getId())) {
            video.setId(Math.abs(UUID.randomUUID().getMostSignificantBits()));
        }
        video.setDataUrl("http://localhost:8080/video/"+video.getId()+"/data");
        videoMap.put(video.getId(), video);
        System.out.println("Added Video " + video.getId());
        return video;
    }

    public static Collection<Video> getVideos() {
        return videoMap.values();
    }
    
    public static Video getById(long id) {
        return videoMap.get(id);
    }
    


}
