from flask import Flask, render_template
import pandas as pd

app = Flask(__name__)

@app.route('/')
def home():
    #sample dataset for the table
    df = pd.read_csv('datasetsforflask\iris.csv').rename(columns={'Unnamed: 0':'No.'})
    return render_template('tableidx.html',data=df)
  
if __name__ == '__main__':
    app.run()