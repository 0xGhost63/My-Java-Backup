class W3T1 {
    String title;
    String genre;
    double rating;
    boolean isSuitableForChildrens;
    
    W3T1(String title,String genre,double rating  ){
        this.title=title;
        this.genre=genre;
        this.rating=rating;
        this.isSuitableForChildrens=checksuitability();
    }
    public boolean checksuitability()
    {
        if(rating <= 8.0)
        return true;
        else
        return false;
    }
    public void display(){
        System.out.print("W3T1:"+title);
        System.out.print(",Genre:"+genre);
        System.out.print(",Rating:"+rating);
        System.out.printf(",Suitability for Childrens: %s\n",isSuitableForChildrens?"Yes":"No");
        
    }
    public static void main(String[] args) {
      W3T1 W3T11=new W3T1("Legends of Maula Jutt","Action",9.2);
      W3T1 W3T12=new W3T1("3 Bahadur","Animation",7.8);
      W3T11.display();
      W3T12.display();
    }
}