package api.Pojo.Get.Pet;

import java.util.List;

public class SuccessFindPet {

    private Integer id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;

    public Integer getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public String getStatus() {
        return status;
    }
}
