/*
  ReadAnalogVoltage
  Reads an analog input on pin 0, converts it to voltage, and prints the result to the serial monitor.
  Attach the center pin of a potentiometer to pin A0, and the outside pins to +5V and ground.
 
 This example code is in the public domain.
 */

/*Rought Zero rate gyro*/
int rateOffset = 0;

/*current andgle*/
float angle = 0;

/*loop counters */
byte loopc = 0;

int averageCount = 1;

// the setup routine runs once when you press reset:
void setup() {
  // initialize serial communication at 9600 bits per second:
  Serial.begin(9600);
  rateOffset = 0;
  for(int i = 0; i < 50; i++)
  {
    rateOffset += 512 - analogRead(A0);
  }
  rateOffset =  rateOffset / 50;
//  rateOffset = ((rateOffset * (5.0 / 1023.0) - (2.5)))/(7.0/1000.0);
  //rateOffset = 0;
}

// the loop routine runs over and over again forever:
void loop() {
  // read the input on analog pin 0:
  long sensorValue = 0;
  loopc++;
  
  /*averaging loop - 1 sample average right now*/
  for(int i = 0; i < averageCount; i++);
  {
    sensorValue += analogRead(A0) + rateOffset;
  }
  

  sensorValue = sensorValue / averageCount;

  //sensorValue = sensorValue & 0xFFFF;
  // Convert the analog reading (which goes from 0 - 1023) to a voltage (0 - 5V):
  float voltage = ((sensorValue * (5.0 / 1023.0) - (2.5)))/(7.0/1000.0);

  /*set up a "dead band" so lose the lower bit to reduce noise drift*/
  /*TODO ROBORIO: Update on RoboRio to use related Roborio values*/
  if(sensorValue > 513 || sensorValue < 511)
  //if(voltage > .3 || voltage < -.3)
  {
    /*TODO ROBORIO: change 0.01 to calculated dt from current / previous loop.*/    
    /*1 / 10 ms = 0.01*/
    angle = angle + voltage * (.01);
  }
  else
  {
    voltage = 0;
  }
  //angle = angle + voltage * .05;
  // print out the value you read:
  
  /*If you print too often you kill the performance of the arduino and accuray dies.*/
  /*TODO ROBORIO: not as applicable on RoboRio*/
  if(loopc % 200 == 0)
  {
    //Serial.print(512 - analogRead(A0));
    //Serial.print(" ");
    Serial.print(voltage);
    Serial.print(" ");
    Serial.println((int)angle % 360);
  }
  
  /*delay -- 10 ms seemed to work ok on ardunio, faster will get higher rate changes. or slower might lower noise*/
  /*TODO ROBORIO: find a good value / schedule for this*/
  delay(10);
}
