import pandas as pd
import matplotlib.pyplot as plt


def generate_bar(data):
    gcash_cnt = data['Gamit_ang_GCash'].value_counts()
    fig,ax = plt.subplots(figsize=(6,4))
    bar = ax.bar(gcash_cnt.index,gcash_cnt.values,color=['green','red'])
    ax.set_title('Gamit ba ang GCash ng mga Tagatugon?')
    ax.set_xlabel('Paggamit ng GCash')
    ax.set_ylabel('Bilang ng mga Tagatugon')
    ax.grid(axis='y', linestyle='--',alpha=0.7)
    ax.set_xticks(range(len(gcash_cnt.index)))
    ax.set_xticklabels(gcash_cnt.index)
    plt.tight_layout()
    plt.show()

def generate_pie(data):
    cnt = data['Pakiramdam_na_Apektado'].value_counts()
    fig,ax = plt.subplots(figsize=(6,4))
    ax.pie(cnt,labels=cnt.index,autopct='%1.1f%%',startangle=140,colors=['red','green','gray'])
    ax.set_title('Naaapektohan ka ba ng makabagong digital na panahon?')
    ax.axis('equal')
    plt.tight_layout()
    plt.show()

def generate_barh(data):
    categ_map = {
        'Mas mababang tubo': 'Presyo at Diskarte sa Kita',
        'Pagtitiyaga at sipag': 'Personal na Katangian',
        'Mga nauusong paninda': 'Pagsabay sa Uso',
        'Buy-and-sell ng motor': 'Alternatibong Kabuhayan',
        'Umaasa sa mamimili': 'Passive o Tradisyunal',
        'Sales talk o budol-budol': 'Presyo at Diskarte sa Kita',
        'Mano-manong bayad (via anak)': 'Tradisyunal na Pamamaraan'
        }
    data['Kategorya_ng_Pagsabay'] = df['Paraan_ng_Pagsabay'].map(categ_map)
    strgy_cnt = data['Kategorya_ng_Pagsabay'].value_counts()
    fig,ax = plt.subplots(figsize=(6,4))
    strgy_cnt.plot(kind='barh',color='skyblue',ax=ax)
    ax.set_title('Mga Pangunahing Paraan ng Pagsabay sa Digital na Panahon')
    ax.set_xlabel('Bilang ng mga Tagatugon')
    ax.set_ylabel('Paraan o Istratehiya')
    ax.grid(axis='x',linestyle='--',alpha=0.7)
    plt.tight_layout()
    plt.show()

def generate_line(data):
    fig,ax = plt.subplots(figsize=(6,4))
    ax.plot(data['Tagatugon'],data['Bilang_ng_Taon_ng_Panininda'],marker='o',linestyle='-',color='blue')
    ax.set_title('Bilang ng Taon ng Pagtitinda')
    ax.set_xlabel('Tagatugon')
    ax.set_ylabel('Bilang ng Taon')
    ax.grid(True,linestyle='--',alpha=0.7)
    plt.tight_layout()
    plt.show()


df = pd.DataFrame({
    "Tagatugon": [1,2,3,4,5,6,7],
    "Bilang_ng_Taon_ng_Panininda": [10,25,18,25,1,0.75,28],  # Estimation for Respondent 3
    "Gamit_ang_GCash": ["Oo","Oo","Hindi","Hindi","Hindi","Hindi","Hindi"],
    "May_Ibang_Teknolohiya": ["Wala","Wala","Wala","Cellphone","Wala","Wala","Wala"],
    "Nagbebenta_Online": ["Hindi","Hindi","Hindi","Hindi","Hindi","Hindi","Hindi"],
    "Pakiramdam_na_Apektado": ["Oo","Oo","Oo","Oo","Hindi","Oo","Hindi Tiyak"],
    "Paraan_ng_Pagsabay": [
        "Mas mababang tubo",
        "Pagtitiyaga at sipag",
        "Mga nauusong paninda",
        "Buy-and-sell ng motor",
        "Umaasa sa mamimili",
        "Sales talk o budol-budol",
        "Mano-manong bayad (via anak)"
    ]
})

#generate_bar(df) call to generate
#generate_pie(df) call to generate
#generate_barh(df) call to generate
#generate_line(df) call to generate