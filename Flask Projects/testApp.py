"""
Download and Install MySQL.

Run MySQL in cmd.

Enter mysql -u root -p (enter password).

Create database using CREATE DATABASE testdb;.

Enter SHOW DATABASES; to see if created successfuly.

Run testApp.py.
"""


from flask import Flask
from flask_mysql_connector import MySQL

#using flask_mysql_connector instead of flask_mysqldb
#flask_mysqldb won't install on laptop
#but everything is same, testApp still connects to a database

app = Flask(__name__)

app.config['MYSQL_USER'] = 'root'
app.config['MYSQL_PASSWORD'] = '1234'
app.config['MYSQL_HOST'] = 'localhost'
app.config['MYSQL_DATABASE'] = 'testdb'

mysql = MySQL(app)

@app.route('/')
def home():
    cur = mysql.connection.cursor()
    cur.execute('CREATE TABLE IF NOT EXISTS testdb (id INTEGER, name VARCHAR(20))')
    cur.execute("INSERT INTO testdb VALUES (1, 'Jerome')")
    cur.execute("INSERT INTO testdb VALUES (2, 'Alice')")
    cur.execute("SELECT * FROM testdb")
    res = cur.fetchall()
    mysql.connection.commit()
    return f'<h1>ID: {str(res[0][0])}, Name: {str(res[0][1])} </h1>'

if __name__ == '__main__':
	app.run(debug=True)
