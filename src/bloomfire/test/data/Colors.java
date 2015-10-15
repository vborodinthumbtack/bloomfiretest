package bloomfire.test.data;

/**
 * Created by Vlad on 15.10.15.
 */
public class Colors
{

    public String brand;
    public String secondary_brand;
    public String highlight;
    public String text;
    public String secondary_text;
    public String link;
    public String top_bar_text;
    public String placeholder_text;
    public String background;
    public String secondary_background;
    public String border;
    public String success;
    public String failure;

    public void assertNotNull()
    {
        assert brand != null;
        assert secondary_brand != null;
        assert highlight != null;
        assert text != null;
        assert secondary_text != null;
        assert link != null;
        assert top_bar_text != null;
        assert placeholder_text != null;
        assert background != null;
        assert secondary_background != null;
        assert border != null;
        assert success != null;
        assert failure != null;
    }
    /*
                "colors": {
                "brand": "#1bb694",
                "secondary_brand": "#b1c9c4",
                "highlight": "#21deb5",
                "text": "#444444",
                "secondary_text": "#6d6f79",
                "link": "#ff8305",
                "top_bar_text": "#ffffff",
                "placeholder_text": "#cccccc",
                "background": "#ffffff",
                "secondary_background": "#f7f7f7",
                "border": "#cccccc",
                "success": "#94e28a",
                "failure": "#dd7777"
            },

     */
}
