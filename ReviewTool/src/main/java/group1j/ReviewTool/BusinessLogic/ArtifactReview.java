/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group1j.ReviewTool.BusinessLogic;

/**
 *
 * @author anilt
 */
public class ArtifactReview {
    
    private int writerID;
    private String text;
    private int reviewID;
    private User writer;
    
    public ArtifactReview(User writer,String text){
        this.writer = writer;
        this.text = text;
    }
}
