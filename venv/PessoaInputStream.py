from Pessoa import *
from client import *
import sys, pickle

class PessoaInputStream:
    def __init__(self, origem):
        self.origem = origem

    def __read__(self):
        texto = ""
        file = open(self.origem, "rb")
        pessoas = pickle.load(file)
        qtd = len(pessoas)
        for p in pessoas:
            print("Bytes do Objeto: {}".format(sys.getsizeof(p)))
            client(message=p, size=qtd)
            qtd = qtd - 1

p1 = Pessoa("Joao Joao", "67308573922", 32)

# print(p1.__str__())
lista = []
lista.append(p1)
lista.append(p1)

print(lista)

pIn = PessoaInputStream("pessoas.txt")
pIn.__read__()