
const int a =  2;
const int b =  3;
const int c =  4;
const int d =  5;
const int e =  6;
const int f =  7;
const int g =  8;
const int pushButton = 9;
int count=0;
int buttonState=0;
int opcion=0;

void setup()
{
  pinMode(pushButton, INPUT);
  pinMode(a, OUTPUT);
  pinMode(b, OUTPUT);
  pinMode(c, OUTPUT);
  pinMode(d, OUTPUT);
  pinMode(e, OUTPUT);
  pinMode(f, OUTPUT);
  pinMode(g, OUTPUT);
  Serial.begin(9600);
  limpiar();
  delay(1000);
  cero();
}

void loop()
{
  if(Serial.available() > 0)
  {
    opcion=Serial.read();
    switch(opcion)
    {
    case '1':
      limpiar();
      count++;
      contar();
      delay(1000);
      leerPushButton();
      opcion ='1';
      break;
    case '2':
      limpiar();
      contar();
      delay(1000);
      leerPushButton();
      opcion ='2';
      break;
    case '3':
      count = 0;
      limpiar();
      contar();
      delay(1000);
      leerPushButton();
      opcion='2';
      break;
    }
  }
  else
  {
    switch(opcion)
    {
    case '1':
      limpiar();
      count++;
      contar();
      delay(1000);
      leerPushButton();
      opcion='1';
      break;
    case '2':
      limpiar();
      contar();
      delay(1000);
      leerPushButton();
      opcion ='2';
      break;
    case '3':
      count = 0;
      limpiar();
      contar();
      delay(1000);
      leerPushButton();
      opcion='2';
      break;
    default:
      leerPushButton();
      break;
    }
  }
}

void leerPushButton()
{
  buttonState = digitalRead(pushButton);
  if (buttonState == HIGH) 
  {
    count++;
    contar();
    buttonState = LOW;
    delay(1000);
  }
}

void contar()
{
  if(count>9)
  {
    count = 0;
  }
  switch(count)
  {
  case 0:
    cero();
    Serial.println("0");
    break;
  case 1:
    uno();
    Serial.println("1");
    break;
  case 2:
    dos();
    Serial.println("2");
    break;
  case 3:
    tres();
    Serial.println("3");
    break;
  case 4:
    cuatro();
    Serial.println("4");
    break;
  case 5:
    cinco();
    Serial.println("5");
    break;
  case 6:
    seis();
    Serial.println("6");
    break;
  case 7:
    siete();
    Serial.println("7");
    break;
  case 8:
    ocho();
    Serial.println("8");
    break;
  case 9:
    nueve();
    Serial.println("9");
    break;
  }
}

void limpiar(){
  digitalWrite(a,HIGH);
  digitalWrite(b,HIGH);
  digitalWrite(c,HIGH);
  digitalWrite(d,HIGH);
  digitalWrite(e,HIGH);
  digitalWrite(f,HIGH);
  digitalWrite(g,HIGH);
}

void cero()
{
  digitalWrite(a,LOW);
  digitalWrite(b,LOW);
  digitalWrite(c,LOW);
  digitalWrite(d,LOW);
  digitalWrite(e,LOW);
  digitalWrite(f,LOW);
  digitalWrite(g,HIGH);
}

void uno()
{
  digitalWrite(a,HIGH);
  digitalWrite(b,LOW);
  digitalWrite(c,LOW);
  digitalWrite(d,HIGH);
  digitalWrite(e,HIGH);
  digitalWrite(f,HIGH);
  digitalWrite(g,HIGH);
}

void dos()
{
  digitalWrite(a,LOW);
  digitalWrite(b,LOW);
  digitalWrite(c,HIGH);
  digitalWrite(d,LOW);
  digitalWrite(e,LOW);
  digitalWrite(f,HIGH);
  digitalWrite(g,LOW);
}

void tres()
{
  digitalWrite(a,LOW);
  digitalWrite(b,LOW);
  digitalWrite(c,LOW);
  digitalWrite(d,LOW);
  digitalWrite(e,HIGH);
  digitalWrite(f,HIGH);
  digitalWrite(g,LOW);
}

void cuatro()
{
  digitalWrite(a,HIGH);
  digitalWrite(b,LOW);
  digitalWrite(c,LOW);
  digitalWrite(d,HIGH);
  digitalWrite(e,HIGH);
  digitalWrite(f,LOW);
  digitalWrite(g,LOW);
}

void cinco()
{
  digitalWrite(a,LOW);
  digitalWrite(b,HIGH);
  digitalWrite(c,LOW);
  digitalWrite(d,LOW);
  digitalWrite(e,HIGH);
  digitalWrite(f,LOW);
  digitalWrite(g,LOW);
}

void seis()
{
  digitalWrite(a,LOW);
  digitalWrite(b,LOW);
  digitalWrite(c,LOW);
  digitalWrite(d,LOW);
  digitalWrite(e,LOW);
  digitalWrite(f,HIGH);
  digitalWrite(g,LOW);
}

void siete()
{
  digitalWrite(a,LOW);
  digitalWrite(b,LOW);
  digitalWrite(c,LOW);
  digitalWrite(d,HIGH);
  digitalWrite(e,HIGH);
  digitalWrite(f,HIGH);
  digitalWrite(g,HIGH);
}

void ocho()
{
  digitalWrite(a,LOW);
  digitalWrite(b,LOW);
  digitalWrite(c,LOW);
  digitalWrite(d,LOW);
  digitalWrite(e,LOW);
  digitalWrite(f,LOW);
  digitalWrite(g,LOW);
}

void nueve()
{
  digitalWrite(a,LOW);
  digitalWrite(b,LOW);
  digitalWrite(c,LOW);
  digitalWrite(d,HIGH);
  digitalWrite(e,HIGH);
  digitalWrite(f,LOW);
  digitalWrite(g,LOW);
}

