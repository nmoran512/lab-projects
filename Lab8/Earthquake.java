/* NOAH A MORAN
[CS2401 - FA23]
This work is to be done individually. It is not permitted to share, reproduce, or alter any part of this
assignment for any purpose. Students are not permitted from sharing code, uploading this
assignment online in any form, or viewing/receiving/modifying code written from anyone else. This
assignment is part of an academic course at The University of Texas at El Paso and a grade will be
assigned for the work produced individually by the student. */

public class Earthquake {
   public double magnitude;
   public String date;
   public String place;

   public void Earthquake(){
   }
   public void Earthquake(double magnitude, String date, String place){
       this.magnitude = magnitude;
       this.date = date;
       this.place = date;
   }
   public void setMagnitude(double magnitude) {
       this.magnitude = magnitude;
   }
   public void setDate(String date){
       this.date = date;
   }
   public void setPlace(String place){
       this.place = place;
   }

    public double getMagnitude() {
        return magnitude;
    }

    public String getDate() {
        return date;
    }

    public String getPlace() {
        return place;
    }
}
