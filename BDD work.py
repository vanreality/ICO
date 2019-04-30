import pandas as pd
import numpy as np

NB_VILLES = 1000

df = pd.read_csv("C://Users//Faucon//Google Drive//centrale//Projet//Serveur//villes_france_2.csv", sep=";", low_memory=False)
print("Nb villes max : "+str(len(df["NOMVILLE"])))
NB_VILLES=min(NB_VILLES,len(df["NOMVILLE"]))
print("Nb de villes pris : "+str(NB_VILLES))
df=df[0:NB_VILLES] # 500 est le nombre de villes max de la BDD créée

matrix = np.zeros([len(df["NOMVILLE"]),len(df["NOMVILLE"])])
nom_villes = []

i=0
j=0
while len(nom_villes)<NB_VILLES:
    nomville = str(df.iloc[j]["NOMVILLE"])
    while "-" in nomville:
        nomville = nomville.replace("-", "_")
    while " " in nomville:
        nomville = nomville.replace(" ", "_")
    while "'" in nomville:
        nomville = nomville.replace("'", "_")
    if nomville not in nom_villes :
        nom_villes.append(nomville)
        lat, long = float(df.iloc[j]["latitude"]), float(df.iloc[j]["longitude"])
        for k in range(j+1, NB_VILLES):
            lat2, long2 = float(df.iloc[k]["latitude"]), float(df.iloc[k]["longitude"])
            try:
                matrix[i][k-(j-i)] = int(np.arccos(np.sin(np.deg2rad(lat))*np.sin(np.deg2rad(lat2)) + np.cos(np.deg2rad(lat))*np.cos(np.deg2rad(lat2))*np.cos(np.deg2rad(long-long2)))*6371)
            except Exception as E:
                print(df.iloc[j])
                matrix[i][k]=0
        print("Ville en cours n°"+str(i))
        i+=1
    j+=1
print("FINI")

matrix = matrix+np.transpose(matrix)
print("Finalement nb de villes = "+str(len(nom_villes)))
NB_VILLES=len(nom_villes)
#matrix = matrix[0:NB_VILLES, 0:NB_VILLES]

df2 = pd.DataFrame(matrix)
for i in range(NB_VILLES):
    df2 = df2.rename(index=int, columns={i: nom_villes[i]})

df2.to_csv("C://Users//Faucon//Google Drive//centrale//Projet//Serveur//BDD.csv")