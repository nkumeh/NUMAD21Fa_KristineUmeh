package edu.neu.madcourse.numad21fa_kristineumeh;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.Objects;

public class DialogBox extends AppCompatDialogFragment {

    private EditText linkName;
    private EditText linkUrl;
    private DialogueBoxListener listener;


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());

        LayoutInflater inflater = requireActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.dialogue_display,null);

        builder.setView(view).setTitle("Add Link")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        })
          .setPositiveButton("OK", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialogInterface, int i) {

              }
          });

//        linkName = view.findViewById(R.id.editName);
//        linkUrl = view.findViewById(R.id.editUrl);

        return builder.create();
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        try{
            listener = (DialogueBoxListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "Please input value");
        }
    }

    public interface DialogueBoxListener {
        void applyText(String linkName, String linkUrl);
    }

}
