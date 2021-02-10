#simport PessoaOutputStream


class Pessoa:
    def __init__(self, nome, cpf, idade):
        self.nome = nome
        self.cpf = cpf
        self.idade = idade

    def __str__(self):
        return " { Nome: %s | CPF: %s | Idade: %d } " % (self.nome, self.cpf, self.idade)


"""
p1 = Pessoa('j', 2023102192199, 29)

# print(p1.__str__())
lista = []
lista.append(p1)
lista.append(p1)

pOut = PessoaOutputStream.PessoaOutputStream(lista, '100')

print(pOut.__str__())
print(pOut._bytes())

"""