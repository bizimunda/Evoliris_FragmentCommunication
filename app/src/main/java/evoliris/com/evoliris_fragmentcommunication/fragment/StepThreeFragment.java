package evoliris.com.evoliris_fragmentcommunication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import evoliris.com.evoliris_fragmentcommunication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StepThreeFragment extends Fragment {

    private Button btnMainThreeSubmit;

    private StepThreeCallback  callback;

    public void setCallback(StepThreeCallback callback){
        this.callback=callback;
    }


    public StepThreeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_step_three, container, false);
        btnMainThreeSubmit = (Button) v.findViewById(R.id.btn_main_three_submit);
        btnMainThreeSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.registerStepThree();
            }
        });

        return v;
    }

    public interface StepThreeCallback{
        void registerStepThree();
    }


}
