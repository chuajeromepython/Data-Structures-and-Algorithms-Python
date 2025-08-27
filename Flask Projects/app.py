from flask import Flask, redirect, url_for, render_template

import math
#import numpy as np

"""
app = Flask(__name__)

#n = np.linspace(-1,1,10)

@app.route('/<name>')
def home(name):
	return render_template('index.html',content=name.upper(),r=math.pi,vals=(''.join(['a','b','c'])).upper())

@app.route('/<name>')
def user(name):
	return f'Hello {name.capitalize()}'

@app.route('/admin/')
def admin():
	return redirect(url_for('user',name='Admin'))
"""


app = Flask(__name__)

@app.route('/')
@app.route('/home/')
def home():
	return render_template('index.html')

@app.route('/about/')
def about():
	return render_template('about.html',name='Jerome')

if __name__ == '__main__':
	app.run()