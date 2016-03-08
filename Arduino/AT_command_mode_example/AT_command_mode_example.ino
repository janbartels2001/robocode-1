
#include <SoftwareSerial.h>

// XBee's DOUN (TX) is connected to pin 8 (Arduino's Software RX)
// XBee's DIN (RX) is connected to pin 9 (Arduino's Software TX)
SoftwareSerial seriall(8,9); // RX, TX
boolean nextLine = false;

void setup() {
  
  Serial.begin(9600);
  seriall.begin(9600);
  
}

void loop() {

  while(Serial.available()){ // there is data being sent from the serial monitor
    seriall.print(char(Serial.read())); //send the data to xbee
  }

  while(seriall.available()){ // there is data being sent from the xbee
    Serial.print(char(seriall.read())); // display data on the serial monitor
    nextLine= true;
  }
  
  if(nextLine){ // applies carraige return only when data is available
    Serial.println();
    nextLine = false;
  }

  delay(10);
}
