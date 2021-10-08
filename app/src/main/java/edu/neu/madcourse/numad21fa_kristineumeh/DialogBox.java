package edu.neu.madcourse.numad21fa_kristineumeh;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class DialogBox extends AppCompatDialogFragment {

    private EditText linkName;
    private EditText linkUrl;
    private DialogBoxListener listener;


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_display, null);

        linkName = (EditText) view.findViewById(R.id.editName);
        linkUrl = (EditText) view.findViewById(R.id.editUrl);

        builder.setView(view).setTitle("Add new links here!")
        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setPositiveButton("Add Link", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                linkName.getText().toString();
                linkUrl.getText().toString();
            }
        });

        return builder.create();
    }

    @Deprecated
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (DialogBoxListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "implement please");
        }

    }

    public interface DialogBoxListener {
        void applyText(String linkName, String linkUrl);

//        okButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int pos = 0;
//
//            }
//        });

//        okButton.setOnClickListener(view1 -> {
//            if (!linkName.getText().toString().isEmpty() &&
//                    !linkUrl.getText().toString().isEmpty()) {
//                Toast.makeText(requireActivity(), "Access granted", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(requireActivity(), "Please try again", Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}
