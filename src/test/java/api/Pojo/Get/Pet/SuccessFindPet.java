package api.Pojo.Get.Pet;

import lombok.Data;
import java.util.List;

@Data
public class SuccessFindPet {

    private Integer id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;

}
