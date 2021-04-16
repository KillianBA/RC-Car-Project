#define ENABLE 5
#define DIRECT_A 3
#define DIRECT_B 4
#define ENABLE1 6
#define FORW 7
#define BACKW 8

#include "IRremote.h"
#include <Servo.h>

int i;
int receiver = 11;
int pos = 0;

Servo myservo;
IRrecv irrecv(receiver);    
decode_results results;
 
void translateIR() 


{

  switch(results.value)

  {
    
  case 0xFFA25D: Serial.println("POWER"); Serial.println(analogRead(13)); break;
  case 0xFFE21D: Serial.println("FUNC/STOP");digitalWrite(ENABLE, LOW); break;
  
  case 0xFF629D: Serial.println("VOL+"); digitalWrite(ENABLE, HIGH); digitalWrite(DIRECT_A, HIGH); digitalWrite(DIRECT_B, LOW); digitalWrite(ENABLE1, HIGH); digitalWrite(FORW, LOW); digitalWrite(BACKW, HIGH); break;
  
  case 0xFF22DD: Serial.println("FAST BACK"); for (pos = 110; pos <= 110; pos += 1) { 
    myservo.write(pos);              
    delay(15); Serial.println(myservo.read());   
 }    break;

 case 0xFF02FD: Serial.println("PAUSE");digitalWrite(ENABLE, LOW); digitalWrite(DIRECT_A, LOW); digitalWrite(DIRECT_B, LOW);for (pos = 50; pos >= 50; pos -= 1){ 
    myservo.write(pos);              
    delay(15);                       
  }    break;

  
  case 0xFFC23D: Serial.println("FAST FORWARD");for (pos = 0; pos >= 0; pos -= 1) { 
    myservo.write(pos);              
    delay(15);                       
  } Serial.println(digitalRead(9));
    break;
    
  case 0xFFE01F: Serial.println("DOWN");    break;
  
  case 0xFFA857: Serial.println("VOL-"); digitalWrite(ENABLE, HIGH); digitalWrite(DIRECT_A, LOW); digitalWrite(DIRECT_B, HIGH); digitalWrite(ENABLE1, HIGH); digitalWrite(FORW, HIGH); digitalWrite(BACKW, LOW);    break;
  
  case 0xFF906F: Serial.println("UP");    break;
  case 0xFF9867: Serial.println("EQ");    break;
  case 0xFFB04F: Serial.println("ST/REPT");    break;
  case 0xFF6897: Serial.println("0");    break;
  case 0xFF30CF: Serial.println("1");    break;
  case 0xFF18E7: Serial.println("2");    break;
  case 0xFF7A85: Serial.println("3");    break;
  case 0xFF10EF: Serial.println("4");    break;
  case 0xFF38C7: Serial.println("5");    break;
  case 0xFF5AA5: Serial.println("6");    break;
  case 0xFF42BD: Serial.println("7");    break;
  case 0xFF4AB5: Serial.println("8");    break;
  case 0xFF52AD: Serial.println("9");    break;
  case 0xFFFFFFFF: Serial.println(" REPEAT");break; 
  default: 
    Serial.println(" other button   ");

  }

  delay(500);


} //END translateIR


void setup() {
  // put your setup code here, to run once:
  pinMode(ENABLE, OUTPUT);
  pinMode(DIRECT_A, OUTPUT);
  pinMode(DIRECT_B, OUTPUT);
  pinMode(9, OUTPUT);
  pinMode(2, OUTPUT);
  pinMode(13, OUTPUT);
  myservo.attach(9); 
  
  Serial.begin(9600);
  
  Serial.println("BUTTON PRESSED"); 
  irrecv.enableIRIn(); 
 
 

 

}

void loop() {
  // put your main code here, to run repeatedly:
    
  int light = analogRead(0)/ 10;
  
    if( light <   20 ){
      
    digitalWrite(2, HIGH);
    delay(1000);
    
  }
  
  else{
    digitalWrite(2, LOW);
  }


  if (irrecv.decode(&results)) 

  {
    translateIR(); 
    irrecv.resume(); 
  }  
}
  
