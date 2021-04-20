/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group1j.ReviewTool.LogicManagement;

/**
 *
 * @author anilt
 */
public class UReview {
    
    private int point;
    private String comment;
    private User reviewer;

    public UReview(int point, String comment, User reviewer) {
        this.point = point;
        this.comment = comment;
        this.reviewer = reviewer;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }
    
    
}
