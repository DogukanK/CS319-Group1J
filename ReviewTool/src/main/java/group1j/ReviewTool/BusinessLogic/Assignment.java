package group1j.ReviewTool.BusinessLogic;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * @author anilt
 * This is the Assignment class, which holds
 * assignment name
 * filePath of the artifact
 * reviews made by various users
 * assignment description
 */
public class Assignment {
    private String name;
    private String filePath;
    private ArrayList<String> artifacts;
    private HashMap<String,ArrayList<ArtifactReview>> artifactReviews;
    private String description;

    public Assignment(String name, String description) {
        this.name = name;
        this.description = description;
        this.artifacts = new ArrayList<>();
        this.artifactReviews = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HashMap<String, ArrayList<ArtifactReview>> getAReviews() {
        return artifactReviews;
    }
    
    public ArrayList<String> getArtifacts(){
        return artifacts;
    }
    
}
