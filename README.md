# Algorithmic-Comparer
Compares the speeds of various searching/sorting algorthims (0.5k, 10k, 20k, 50k elements)

# Version 1.02
-> Currently checks up to 50k elements for shell sorting only

![capture](https://cloud.githubusercontent.com/assets/27081909/24845246/7dd38fd6-1d7e-11e7-9c1c-d785fd501893.JPG)

# Next Step
-> Will incorperate selection/bubble sort in version 1.03


// SecreteCode

int trigPin = 9;
int echoPin = 10;
int LBack = 4;
int RBack = 7;
int LMotor = 5;
int RMotor = 6;
int pot2 = A1;
int pot1 = A0;

void setup() {
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);
  pinMode(LBack, OUTPUT);
  pinMode(LBack, OUTPUT);
  pinMode(RMotor, OUTPUT);
  pinMode(LMotor, OUTPUT);
Serial.begin(9600); 
}

// the loop function runs over and over again forever
void loop() {
 float LSensor = analogRead(pot2);
 float RSensor = analogRead(pot1);
Serial.println(LSensor);
 
 //goForwards(80) ; 
 /*if(getDistance() == 5){
  
   turnRight(150, 200) ; 
   }
 */
}
int getDistance() {
  long duration, distance;
  digitalWrite(trigPin,HIGH);
  delayMicroseconds(1000);
  digitalWrite(trigPin, LOW);
  duration=pulseIn(echoPin, HIGH);
  distance =(duration/2)/29.1;
  Serial.print(distance);
  Serial.println("CM");
  delay(10);

  return distance ; 
}


void goForwards(int speed) {
   analogWrite(LMotor, speed);
   analogWrite(RMotor, speed);
   analogWrite(LBack, 0);
   analogWrite(RBack, 0);
}
void stopMoving() {
  digitalWrite(RBack, LOW);
  digitalWrite(RMotor, LOW);
  digitalWrite(LBack, LOW);
  digitalWrite(LMotor, LOW);
}
void goBackwards(int speed) {
  analogWrite(LMotor, speed);
  analogWrite(RBack, speed);
  analogWrite(RMotor, speed);
  analogWrite(LBack, speed);
}

void turnRight(int speed, int time){
   analogWrite(LMotor, speed);
    analogWrite(RMotor, speed);
    digitalWrite(LBack, LOW);
    analogWrite(RBack, speed);
     delay(time);
      digitalWrite(LMotor, LOW);
      digitalWrite(RMotor, LOW);
      digitalWrite(RBack, LOW);
}
void turnLeft(int speed, int time){
    analogWrite(LMotor, speed);
   analogWrite(RMotor, speed);
    analogWrite(LBack, speed);
     digitalWrite(RBack, LOW);
     delay(time);
      digitalWrite(RMotor, LOW);
       digitalWrite(LMotor, LOW);
        digitalWrite(LBack, LOW);
}






