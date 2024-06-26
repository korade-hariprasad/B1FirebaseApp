package a.practice.b1firebaseapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddStudentInfoActivity extends AppCompatActivity {

    TextInputEditText etName;
    TextInputEditText etAge;
    Button btnAdd;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db=FirebaseFirestore.getInstance();
        setContentView(R.layout.activity_add_student_info);
        etAge=findViewById(R.id.etAge);
        etName=findViewById(R.id.etName);
        btnAdd=findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DocumentReference docRef=db.collection("students").document();
                String docId=docRef.getId();
                String name=etName.getText().toString().trim();
                int age=Integer.parseInt(etAge.getText().toString().trim());

                db.collection("students")
                        .document(docId)
                        .set(new Student(docId,name,age))
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                if(task.isSuccessful())
                                {
                                    Toast.makeText(AddStudentInfoActivity.this, "Student Added", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(AddStudentInfoActivity.this, "Failed to add student", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(AddStudentInfoActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

    }
}