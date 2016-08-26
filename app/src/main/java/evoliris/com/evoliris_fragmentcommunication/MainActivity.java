package evoliris.com.evoliris_fragmentcommunication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import java.util.Date;

import evoliris.com.evoliris_fragmentcommunication.fragment.StepOneFragment;
import evoliris.com.evoliris_fragmentcommunication.fragment.StepThreeFragment;
import evoliris.com.evoliris_fragmentcommunication.fragment.StepTwoFragment;
import evoliris.com.evoliris_fragmentcommunication.model.User;


public class MainActivity extends ActionBarActivity implements StepOneFragment.StepOneCallback, StepTwoFragment.StepTwoCallback, StepThreeFragment.StepThreeCallback {
    private User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentUser = new User();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        StepOneFragment stepOneFragment = new StepOneFragment();
        stepOneFragment.setCallback(this);
        transaction.add(R.id.f1_main_ocntainer, stepOneFragment);
        transaction.addToBackStack("Stepon");
        transaction.commit();

    }


    @Override
    public void registerStepOne(String username, String password) {
        currentUser.setUsername(username);
        currentUser.setPassword(password);

        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction transaction= fm.beginTransaction();

        StepTwoFragment stepTwoFragment= new StepTwoFragment();
        stepTwoFragment.setCallback(this);
        transaction.replace(R.id.f1_main_ocntainer, stepTwoFragment);

        transaction.addToBackStack("StepTwo");
        transaction.commit();

    }

    @Override
    public void registerStepTwo(Date dob) {
        currentUser.setDateOfBirth(dob);

        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction transaction= fm.beginTransaction();

        StepThreeFragment stepThreeFragment= new StepThreeFragment();
        stepThreeFragment.setCallback(this);
        transaction.replace(R.id.f1_main_ocntainer, stepThreeFragment);
        transaction.addToBackStack("StepThree");
        transaction.commit();
    }

    @Override
    public void registerStepThree() {
        //TODO save in DB

        Log.i("User: ",currentUser.getUsername()
                +" "+currentUser.getPassword()
                +" "+currentUser.getDateOfBirth());

        Intent toDemo= new Intent(MainActivity.this, DemoActivity.class);
        toDemo.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(toDemo);
        finish();

    }
}
