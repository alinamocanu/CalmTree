package com.example.calmtree.ui.thought;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.calmtree.R;
import com.example.calmtree.model.FTB;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewHandout extends AppCompatActivity {
    final DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    DatabaseReference handoutRef = database.child("FTB");
    EditText whatIFelt;
    EditText whatIThought;
    EditText whatIDid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_handout);
        Button save = findViewById(R.id.button4);

        save.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(getApplicationContext(),"Saved!",Toast.LENGTH_SHORT).show();
                                        whatIFelt = findViewById(R.id.editText);
                                        whatIThought = findViewById(R.id.editText2);
                                        whatIDid = findViewById(R.id.editText3);

                                        FTB handout = new FTB();
                                        handout.setWhatIFelt(whatIFelt.getText().toString());
                                        handout.setWhatIThought(whatIThought.getText().toString());
                                        handout.setWhatIDid(whatIDid.getText().toString());

                                        DatabaseReference newRef = handoutRef.push();
                                        newRef.setValue(handout);


                                    }
                                }
        );
    }
}
