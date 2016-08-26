package evoliris.com.evoliris_fragmentcommunication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import evoliris.com.evoliris_fragmentcommunication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StepOneFragment extends Fragment {

    private EditText etMainOneUsername;
    private EditText etMainOnePassword;
    private Button btnMainOneSubmit;

    private StepOneCallback callback;

    public void setCallback(StepOneCallback callback){
        this.callback=callback;
    }


    public StepOneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_step_one, container, false);

        etMainOneUsername= (EditText) v.findViewById(R.id.et_main_one_username);
        etMainOnePassword= (EditText) v.findViewById(R.id.et_main_one_password);
        btnMainOneSubmit= (Button) v.findViewById(R.id.btn_main_one_submit);

        btnMainOneSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.registerStepOne(etMainOneUsername.getText().toString(), etMainOneUsername.getText().toString());
            }
        });
        return v;
    }

    public interface StepOneCallback{
        void registerStepOne(String username, String password);
    }


}
