package janlochba.recommender;

public class AnalysisMethod {

    public String recAnalysisMethod( String s1, String s2 ){

        String recommendation;

        if(s1.equals("a")&&s2.equals("")){
             recommendation = "a";
        } if (s1.equals("b")&&s2.equals("")){
            recommendation = "b";
        } else {
            recommendation = "c";
        }

        return recommendation;
    }

}
