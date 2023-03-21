package com.example.myapp;
import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.util.*;

import android.view.View.*;

public class Second extends Activity 
{
	private int currentQuistionPosition=0;
	private String selectedOptionByUser ="";
	private Timer quTime;
	private int totalMinute=0;
	private  int second =59;
	private List<QuistionList>quistionList;
	LinearLayout l;
	Button b;
	EditText e1;
	EditText e2;
	EditText e3;
	TextView t1;
	Button b1;
	Button b2;
	Intent intent;
	TextView quistion;
	TextView quistions;
	Button op1,op2,op3,op4;
	Button ok;
	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
		
		final String getSelectedTobicName =getIntent().getStringExtra("selectedTobic");
		TextView texr=findViewById(R.id.er);
		settime(texr);
		quistions=findViewById(R.id.quistions);
		quistion=findViewById(R.id.quistion);
		TextView tobicName =findViewById(R.id.tobicName);
		tobicName.setText(getSelectedTobicName);


	op1=findViewById(R.id.op1);
		op2=findViewById(R.id.op2);
		op3=findViewById(R.id.op3);
		op4=findViewById(R.id.op4);
		ok=findViewById(R.id.ok);
		quistionList=QuistionBank.getQuistion(getSelectedTobicName);
		quistions.setText((currentQuistionPosition+1)+"/"+quistionList.size());
		quistion.setText(quistionList.get(0).getquistion());
		op1.setText(quistionList.get(0).getOp1());
		op2.setText(quistionList.get(0).getOp2());
		op3.setText(quistionList.get(0).getOp3());
	    op4.setText(quistionList.get(0).getOp4());

		TextView correctAnswer=findViewById(R.id.correctAnswer);
		TextView inCorrectAnswer=findViewById(R.id.inCorrectAnswer);
		



		/*op1.setOnClickListener(new View.OnClickListener(){

				@Override
				public void onClick(View p1)
				{if(selectedOptionByUser.isEmpty()){selectedOptionByUser=op1.getText().toString();
				op1.setBackgroundColor(Color.RED);
				op1.setTextColor(Color.WHITE);
				
				quistionList.get(currentQuistionPosition).setUserSelectedAnswer(selectedOptionByUser);
						revealAnswer();
				}
					// TODO: Implement this method
				}
			});*/
		op1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					selectedOptionByUser = ((Button)v).getText().toString();
					quistionList.get(currentQuistionPosition).setUserSelectedAnswer(selectedOptionByUser);
					// ...
				}
			});
		/*op2.setOnClickListener(new View.OnClickListener(){

				@Override
				public void onClick(View p1)
				{if(selectedOptionByUser.isEmpty()){selectedOptionByUser=op1.getText().toString();
						op2.setBackgroundColor(Color.RED);
						op2.setTextColor(Color.WHITE);
						
						quistionList.get(currentQuistionPosition).setUserSelectedAnswer(selectedOptionByUser);
						revealAnswer();
					}
					// TODO: Implement this method
				}
			});*/
		op2.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					selectedOptionByUser = ((Button)v).getText().toString();
					quistionList.get(currentQuistionPosition).setUserSelectedAnswer(selectedOptionByUser);
					// ...
				}
			});

		/*op3.setOnClickListener(new View.OnClickListener(){

				@Override
				public void onClick(View p1)
				{if(selectedOptionByUser.isEmpty()){selectedOptionByUser=op1.getText().toString();
						op3.setBackgroundColor(Color.RED);
						op3.setTextColor(Color.WHITE);
						
						quistionList.get(currentQuistionPosition).setUserSelectedAnswer(selectedOptionByUser);
						revealAnswer();
					}
					// TODO: Implement this method
				}
			});*/
		op3.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					selectedOptionByUser = ((Button)v).getText().toString();
					quistionList.get(currentQuistionPosition).setUserSelectedAnswer(selectedOptionByUser);
					// ...
				}
			});/*
		op4.setOnClickListener(new View.OnClickListener(){

				@Override
				public void onClick(View p1)
				{if(selectedOptionByUser.isEmpty()){selectedOptionByUser=op1.getText().toString();
						op4.setBackgroundColor(Color.RED);
						op4.setTextColor(Color.WHITE);
						
						quistionList.get(currentQuistionPosition).setUserSelectedAnswer(selectedOptionByUser);
						revealAnswer();
					}
					// TODO: Implement this method
				}
			});*/
		op4.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					selectedOptionByUser = ((Button)v).getText().toString();
					quistionList.get(currentQuistionPosition).setUserSelectedAnswer(selectedOptionByUser);
					// ...
				}
			});
		/*ok.setOnClickListener(new View.OnClickListener(){

				@Override
				public void onClick(View p1)
				{if(selectedOptionByUser.isEmpty()){
					Toast.makeText(Second.this,"choooose😪",Toast.LENGTH_SHORT).show();}
					else{
						
					changeNextQuistion();
						
					}
}
					// TODO: Implement this method
				
			});*/
		ok.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					if (currentQuistionPosition == quistionList.size() - 1) {
						Intent intent = new Intent(Second.this, Third.class);
						intent.putExtra("correct", getResult());
						intent.putExtra("total", quistionList.size());
						startActivity(intent);
					} else {
						changeNextQuistion();
					}
				}
			});
		
		//correctAnswer.setText(getResult());
		//inCorrectAnswer.setText(String.valueOf(getinCorrectAnswer()));
				
}





	private void settime (final TextView timerTextView){

        quTime = new Timer();
        quTime.scheduleAtFixedRate(new TimerTask() {
				@Override
				public void run() {

					if (second==0&&totalMinute==0) {

						quTime.purge();

						quTime.cancel();

						op2=findViewById(R.id.op2);
						op2.setText("NotYour");
						//intent=new Intent(Second.this,Third.class);
						//intent.putExtra("correct",getCorrectAnswer());
						//intent.putExtra("incorrect",getinCorrectAnswer());
						startActivity(intent);
						finish();
					}
					else if(second==0){totalMinute--;second=59;

					}

					else {second--;}




					runOnUiThread(new Runnable() {
							@Override
							public void run() {

								timerTextView.setText(totalMinute+":"+second);

								if(second==0&&totalMinute==0)
								{Toast.makeText(getApplicationContext(),"Time Over😒",Toast.LENGTH_SHORT).show();	}
							}
						});
				}
			},1000, 1000);
    }
	/*private final int getCorrectAnswer(){
		int CorrectAnswer=0;
		for(int i=0;i<quistionList.size();i++){
			String getUserSelectedAnswer=quistionList.get(i).getUserSelectedAnswer();
			String getanswer=quistionList.get(i).getanswer();
			if(getUserSelectedAnswer.equals(getanswer)){CorrectAnswer++;}
		}
		return CorrectAnswer;
	}

    private int getinCorrectAnswer(){
		int incorrectAnswer=0;
		for(int i=0;i<quistionList.size();i++){
			final String getUserSelectedAnswer=quistionList.get(i).getUserSelectedAnswer();
			final String getanswer=quistionList.get(i).getanswer();
			if(!(getUserSelectedAnswer.equals(getanswer))){incorrectAnswer++;}
		}
		return incorrectAnswer;
	}*/
	public String getResult() {
		int CorrectAnswer = 0;
		int incorrectAnswer = 0;
		for (int i = 0; i < quistionList.size(); i++) {
			String getUserSelectedAnswer = quistionList.get(i).getUserSelectedAnswer();
			String getanswer = quistionList.get(i).getanswer();
			if (getUserSelectedAnswer.equals(getanswer)) {
				CorrectAnswer++;
			} else {
				incorrectAnswer++;
			}
		}
		return  "Correct: " + CorrectAnswer + ", Incorrect: " + incorrectAnswer;
		
	}
	/*private int getCorrectAnswers() {
		int correctAnswers = 0;
		for (QuistionList quistion : quistionList) {
			if (quistion.getUserSelectedAnswer() != null && quistion.getUserSelectedAnswer().equals(quistion.getanswer())) {
				correctAnswers++;
			}
		}
		return correctAnswers;
	}*/

	@Override
	public void onBackPressed()
	{
		// TODO: Implement this method
		quTime.purge();
		quTime.cancel();
		startActivity( new Intent(Second.this,MainActivity.class));
		finish();
	}
private void revealAnswer (){
	final String getanswer=quistionList.get(currentQuistionPosition).getanswer();
	//final String getuserselectedAnswer=quistionList.get(currentQuistionPosition).getUserSelectedAnswer();
	if(op1.getText().toString().equals(getanswer)){
		op1.setBackgroundColor(Color.GREEN);
		op1.setTextColor(Color.WHITE);
		}
	else if(op2.getText().toString().equals(getanswer)){
		
		op2.setBackgroundColor(Color.GREEN);
		op2.setTextColor(Color.WHITE);
	}
	else if(op3.getText().toString().equals(getanswer)){

		op3.setBackgroundColor(Color.GREEN);
		op3.setTextColor(Color.WHITE);
	}
	else if(op4.getText().toString().equals(getanswer)){

		op4.setBackgroundColor(Color.GREEN);
		op4.setTextColor(Color.WHITE);
	}
}
private void changeNextQuistion (){
	currentQuistionPosition++;
	if((currentQuistionPosition+1)==quistionList.size()){
		
		ok.setText("submit Quize");
		
	}
	if (currentQuistionPosition<quistionList.size()){
		selectedOptionByUser="";
	
	op1.setBackgroundColor(Color.GRAY);
	op1.setTextColor(Color.BLACK);
	
		op2.setBackgroundColor(Color.GRAY);
		op2.setTextColor(Color.BLACK);
		op3.setBackgroundColor(Color.GRAY);
		op3.setTextColor(Color.BLACK);
		op4.setBackgroundColor(Color.GRAY);
		op4.setTextColor(Color.BLACK);
		quistions.setText((currentQuistionPosition+1)+"/"+quistionList.size());
		quistion.setText(quistionList.get(currentQuistionPosition).getquistion());
		op1.setText(quistionList.get(currentQuistionPosition).getOp1());
		op2.setText(quistionList.get(currentQuistionPosition).getOp2());
		op3.setText(quistionList.get(currentQuistionPosition).getOp3());
	    op4.setText(quistionList.get(currentQuistionPosition).getOp4());
		
	}else{intent=new Intent(Second.this,Third.class);
		//intent.putExtra("correct",getCorrectAnswer());
		//intent.putExtra("incorrect",getinCorrectAnswer());
	startActivity(intent);
	finish();
	}
	
	
}


}
