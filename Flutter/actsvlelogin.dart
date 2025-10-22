import 'package:flutter/material.dart';

void main(){
  runApp(MyApp());
}

class MyApp extends StatelessWidget{
  MyApp({Key? key}): super(key: key);
  
  @override
  Widget build(BuildContext context){
    return MaterialApp(
      debugShowMaterialGrid: false,
      debugShowCheckedModeBanner: false,
      title: 'Login',
      home: LogInPage(),
    );
  }
}

class LogInPage extends StatefulWidget{
  LogInPage({Key? key}): super(key: key);
  
  @override
  State<LogInPage> createState(){
    return _LogInPage();
  }
}

class _LogInPage extends State<LogInPage>{
  var _formKey = GlobalKey<FormState>();
  
  void _success(){
   ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(
          backgroundColor: Colors.green[900],
          content: Center(
            child: Text(
              'Login Successful!',
              style: TextStyle(
                color: Colors.white,
              ),
            ),
          ),
        ),
     );
  }
  
  void _failed(){
    ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(
          backgroundColor: Colors.green[900],
          content: Center(
            child: Text(
              'Failed to login',
              style: TextStyle(
              color: Colors.white,
              ),
            ),
          ),
        ),
     );
  }
  
  void _submitForm(){
    final isValid = _formKey.currentState!.validate();
    if (isValid){
      _success();
    } else {
      _failed();
    }
    _formKey.currentState!.save();
  }
  
  @override
  Widget build(BuildContext context){
    return Scaffold(
      backgroundColor: Colors.green[50],
      appBar: AppBar(
        backgroundColor: Colors.green[900],
        title: Padding(
          padding: EdgeInsets.all(10.0),
          child: Row(
            children: <Widget>[
              Icon(
                Icons.person,
                color: Colors.white,
              ),
              SizedBox(width: 10),
              Text(
                'ACTS-VLE',
                style: TextStyle(
                  color: Colors.white,
                ),
              ),
            ],
          ),
        ),
      ),
      body: Center(
        child: SizedBox(
          height: 600,
          width: 350,
          child: Card(
            child: Padding(
              padding: EdgeInsets.all(20.0),
              child: Center(
                child: Form(
                  key: _formKey,
                  child: Column(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: <Widget>[
                      Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: <Widget>[
                          Text(
                            'ACTS',
                            style: TextStyle(
                              fontSize: 30,
                              color: Colors.green[900],
                              fontWeight: FontWeight.bold,
                              
                            ),
                          ),
                          SizedBox(height: 30,),
                      Text(
                        'VIRTUAL LEARNING ENVIRONMENT',
                        style: TextStyle(
                          color: Colors.green[900],
                          fontWeight: FontWeight.bold,
                          fontSize: 17,
                        ),
                      ),
                        ],
                      ),
                      SizedBox(height: 60,),
                      TextFormField(
                        keyboardType: TextInputType.emailAddress,
                        decoration: InputDecoration(labelText: 'Email'),
                        validator: (value){
                          if (value!.isEmpty){
                            return 'Must Enter Email';
                          }
                          if (!RegExp(r"^[a-zA-Z0-9.a-zA-Z0-9.!#$%&'*+-/=?^_`{|}~]+@[a-zA-Z0-9]+\.[a-zA-Z]+").hasMatch(value)){
                            return 'Invalid Email';
                          }
                          return null;
                        },
                      ),
                      SizedBox(height: MediaQuery.of(context).size.width * 0.1),
                      TextFormField(
                        obscureText: true,
                        decoration: InputDecoration(labelText: 'Password'),
                        validator: (value){
                          if (value!.isEmpty){
                            return 'Must Enter Password';
                          }
                          return null;
                        },
                      ),
                      SizedBox(height: MediaQuery.of(context).size.width * 0.1),
                      SizedBox(
                        width: double.infinity,
                        child: ElevatedButton(
                          style: ButtonStyle(
                          backgroundColor: WidgetStateProperty.all(Colors.green[900]),
                          ),
                          onPressed: _submitForm,
                          child: Text(
                            'Login',
                            style: TextStyle(
                              color: Colors.white,
                            ),
                          ),
                        ),
                      ),
                   ],
                  ),
                ),
              ),
            ),
          ),
        ),
      ),
    );
  }
}
