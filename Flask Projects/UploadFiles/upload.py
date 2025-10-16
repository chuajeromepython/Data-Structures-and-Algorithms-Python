from flask import Flask, render_template, request, redirect, url_for
from fileinput import filename

app = Flask(__name__)

@app.route('/')
def home():
    return render_template('uploadidx.html') 

@app.route('/upload',methods=['POST'])
def upload():
    f = request.files['file']

    if f.filename == '':
        return redirect(url_for('failed'))

    if request.method == 'POST':
        f.save(f.filename)
        return render_template('awknowledge.html',name=f.filename)

@app.route('/failed')
def failed():
    return render_template('nofile.html')

if __name__ == '__main__':
	app.run(debug=True)
    