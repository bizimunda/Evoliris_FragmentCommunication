package evoliris.com.evoliris_fragmentcommunication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;

import evoliris.com.evoliris_fragmentcommunication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StepTwoFragment extends Fragment {

    private DatePicker datePicker;
    private Button btnMainTwoSubmit;

    private StepTwoCallback callback;

    public void setCallback(StepTwoCallback callback){
        this.callback=callback;
    }


    public StepTwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_step_two, container, false);
        datePicker= (DatePicker) v.findViewById(R.id.dp_main_two_dob);
        btnMainTwoSubmit= (Button) v.findViewById(R.id.btn_main_two_submit);

        btnMainTwoSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar c= Calendar.getInstance();
                c.set(datePicker.getYear(), datePicker.getMonth()-1, datePicker.getDayOfMonth());

                Date dob= c.getTime();
                callback.registerStepTwo(dob);

            }
        });

        return v;
    }

    public interface StepTwoCallback{
        void registerStepTwo(Date dob);
    }


}
