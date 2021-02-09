from client import *

class InvertCaseReader:
    def __init__(self, destino):
        self.destino = destino

    def __reader__(self):
        texto = ""
        file = open(self.destino, "r")
        texto = file.readline()
        print(texto)
        client(message=texto)



arq = input("Nome arquivo: ")
obj = InvertCaseReader(arq)

obj.__reader__()

