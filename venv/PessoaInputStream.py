from Pessoa import *
import sys

class PessoaInputStream:
    def __init__(self, origem):
        self.origem = origem


p1 = Pessoa("Joao Joao", "67308573922", 32)

# print(p1.__str__())
lista = []
lista.append(p1)
lista.append(p1)

print(lista)