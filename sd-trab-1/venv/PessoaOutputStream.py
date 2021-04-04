import pickle, sys

from client import *
from Pessoa import *


class PessoaOutputStream:
    def __init__(self, dados, destino):
        self.dados = dados
        self.destino = destino
        self.size = len(dados)



    def __str__(self):
        message = ''
        for p in self.dados:
            message += p.__str__()
        return message

    def _envio_(self):
        file = open(self.destino, "wb")
        pickle.dump(self.dados, file)
        message = self.dados
        obj_bytes = pickle.dumps(self.dados)
        qtd = self.size

        for p in self.dados:
            print("Bytes do Objeto: {}" .format(sys.getsizeof(p)))
            client(message=p, size=qtd)
            qtd = qtd - 1


p1 = Pessoa("Joao Joao", "67308573922", 40)
p2 = Pessoa("Maria Maria", "4473402112", 28)


# print(p1.__str__())
lista = []
lista.append(p1)
lista.append(p2)
print(lista.__str__())

pOut = PessoaOutputStream(lista, "pessoas.txt")
print(pOut.__str__())

pOut._envio_()
# print(pOut.__str__())
# print(pOut._bytes())

# client()
