package edu.css.unit_10_app;


import java.util.List;
        import java.util.Random;

        import android.app.ListActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {
    private CommentsDataSource datasource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creates a new link to the database
        datasource = new CommentsDataSource(this);
        datasource.open();

        List<Comment> values = datasource.getAllComments();

        // use the SimpleCursorAdapter to show the
        // elements in a ListView
        ArrayAdapter<Comment> adapter = new ArrayAdapter<Comment>(this,
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }

    /**
     * This method checks what button was clicked and performs the action requested
     * @param view
     */
    // Will be called via the onClick attribute
    // of the buttons in main.xml
    public void onClick(View view) {
        @SuppressWarnings("unchecked")
        ArrayAdapter<Comment> adapter = (ArrayAdapter<Comment>) getListAdapter();
        Comment comment = null;
        switch (view.getId()) {
            case R.id.add: //if add is selected, add a random comment
                String[] comments = new String[] { "Cool", "Very nice", "Hate it" };
                int nextInt = new Random().nextInt(3);
                // save the new comment to the database
                comment = datasource.createComment(comments[nextInt]);
                adapter.add(comment);
                break;
            case R.id.delete: //if delete is selected, the first row will be removed
                if (getListAdapter().getCount() > 0) {
                    comment = (Comment) getListAdapter().getItem(0);
                    datasource.deleteComment(comment);
                    adapter.remove(comment);
                }
                break;
        }
        adapter.notifyDataSetChanged();
    }

    /**
     * When the app is resumed, open the database connection
     */
    @Override
    protected void onResume() {
        datasource.open();
        super.onResume();
    }

    /**
     * When the app is paused, close the database connection
     */
    @Override
    protected void onPause() {
        datasource.close();
        super.onPause();
    }

}
