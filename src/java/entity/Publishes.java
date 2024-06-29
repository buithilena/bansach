/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author vuhoa
 */
public class Publishes {
    private String publish_id; 
    private String publish_name; 
    private Boolean statusDelete; 

    public Publishes() {
    }

    public Publishes(String publish_name, Boolean statusDelete) {
        this.publish_name = publish_name;
        this.statusDelete = statusDelete;
    }

    public Publishes(String publish_id, String publish_name, Boolean statusDelete) {
        this.publish_id = publish_id;
        this.publish_name = publish_name;
        this.statusDelete = statusDelete;
    }

    public String getPublish_id() {
        return publish_id;
    }

    public String getPublish_name() {
        return publish_name;
    }

    public Boolean getStatusDelete() {
        return statusDelete;
    }

    public void setPublish_id(String publish_id) {
        this.publish_id = publish_id;
    }

    public void setPublish_name(String publish_name) {
        this.publish_name = publish_name;
    }

    public void setStatusDelete(Boolean statusDelete) {
        this.statusDelete = statusDelete;
    }

    @Override
    public String toString() {
        return "Publishes{" + "publish_id=" + publish_id + ", publish_name=" + publish_name + ", statusDelete=" + statusDelete + '}';
    }
    
}
