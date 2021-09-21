package br.com.zup;

import java.util.Scanner;

public class Main {

        public static void main(String[] args) {

            Scanner input = new Scanner(System.in);

            // Variáveis globais do sistema
            float gasto, valor;
            int opcao, pessoa, senha;
            // inicializando algumas variáveis
            float va = -1; // vale alimentação o valor atribuido negativo deve-se a cair no loop para não ser negativo
            float vc = -1; // vale combustivel
            float vr = -1; // vale refeição
            float multibeneficios = -1; //multibeneficios
            boolean sair = false; // controla loop do programa + loop de usuário
            boolean administrador = false; // controla loop de programa com acesso de administrador
            boolean resetar = true; // controla loop do programa inteiro
            boolean admpessoa; // controla loop para definir qual usuário está acessando

            // Inicializando o loop principal do programa
            while (resetar) {

                // Tela inicial: Tipos de cartões disponiveis e solicita definir o saldo de cada cartão
                System.out.printf("%n-------------------------------" +
                        "%nOlá, seja bem vindo ao sistema de cartões Cartão novo." +
                        "%nOs cartões Líderes" +
                        "%n-------------------------------" +
                        "%nPor favor, informe o saldo dos seguintes cartões:%n");

                // Verificação se o valor é negativo; sai do loop quando digitar um valor positivo ou zero
                while (va < 0) {
                    System.out.printf("%nInsira um valor positivo de crédito para inserir no vale alimentação: R$ ");
                    va = input.nextFloat();
                    if (va < 0) {
                        System.out.printf("ERRO! O valor digitado é negativo%n");
                    }
                }

                while (vc < 0) {
                    System.out.printf("%nInsira um valor positivo de crédito para inserir no vale Combustivel: R$ ");
                    vc = input.nextFloat();
                    if (vc < 0) {
                        System.out.printf("ERRO! O valor digitado é negativo%n");
                    }
                }

                while (vr < 0) {
                    System.out.printf("%nInsira um valor positivo de crédito para o vale refeição: R$ ");
                    vr = input.nextFloat();
                    if (vr < 0) {
                        System.out.printf("ERRO! O valor digitado é negativo%n");
                    }
                }

                while (multibeneficios < 0) {
                    System.out.printf("%nInsira um valor positivo de crédito para o Multibeneficios: R$ ");
                    multibeneficios = input.nextFloat();
                    if (multibeneficios < 0) {
                        break;
                    }

                        System.out.printf("ERRO! O valor digitado é negativo%n");


                        // Liberando acesso a tela de escolha de privilégio
                        admpessoa = true;

                        // Inicia o loop para a escolha do privilégio de usuário. Não permite opções inválidas
                        while (admpessoa) {
                            System.out.printf("-------------------------------" +
                                    "%nEscolha a sua opção:" +
                                    "%n1 - Administrador" +
                                    "%n2 - Usuário" +
                                    "%n0 - Encerrar programa" +
                                    "%n%nOpção desejada: ");
                            pessoa = input.nextInt();

                            // Verificação se o usuário é um administrador através de senha
                            if (pessoa == 1) {
                                // Solicitação para digitar a senha
                                System.out.print("Digite a senha [0 para ir para usuário]: ");
                                senha = input.nextInt();

                                // Verificação se a senha está correta
                                if (senha == 1234) {
                                    System.out.print("Bem vindo, administrador.");
                                    administrador = true; // O menum do adminstrador esta ativo
                                    admpessoa = false; // o loop da seleção de usuário está desativado
                                    sair = true;// O loop para encerrar o programa está ativo esta ativo
                                }

                                //  Permissão para ir ao console de usuário sem privilégio de administrador
                                else if (senha == 0) {
                                    sair = true;
                                }

                                // Loop para tentar senha enquanto não acertar com no máximo mais 3 tentativas
                                else {
                                    for (int i = 1; i <= 4; i++) {
                                        if (senha == 0) {
                                            sair = true;
                                            i = 4;
                                        }

                                        // Limitação para três tentativas
                                        // Pula após as 4 tentativas
                                        if (i == 4) {
                                            continue;
                                        }

                                        // Singular caso falte apenas uma tentativa
                                        else if (i == 3) {
                                            System.out.printf("SENHA INVÁLIDA." +
                                                    "%nVocê tem mais 1 tentativa" +
                                                    "%nTente novamente [0 para ir para usuário]: ");
                                            senha = input.nextInt();
                                        } else {
                                            System.out.printf("SENHA INVÁLIDA." +
                                                    "%nVocê tem mais %d tentativas" +
                                                    "%nTente novamente [0 para ir para usuário]: ", 4 - i);
                                            senha = input.nextInt();
                                        }

                                        // Validação da senha e encaminhamento para a próxima tela caso acerte a senha
                                        if (senha == 1234) {
                                            admpessoa = false;
                                            administrador = true;
                                            resetar = false;
                                            sair = true;
                                            i = 5;
                                        }
                                    }
                                }
                            }

                            // Seleção privilégio de usuário
                            else if (pessoa == 2) {
                                admpessoa = false;
                                sair = true;
                            }

                            // Encerrar completamente o programa
                            else if (pessoa == 0) {
                                System.out.printf("%n-------------------------------" +
                                        "%nObrigado por utilizar o programa. Até logo!");
                                admpessoa = false;
                                resetar = false;
                            }

                            // Opção inválida
                            else {
                                System.out.printf("%n-------------------------------" +
                                        "%nOpção inválida, tente novamente.%n ");
                            }

                            if (sair) {
                                System.out.printf("%n-------------------------------" +
                                        "%nBem vindo! O saldo atual é:" +
                                        "%nVale Alimentação: R$ %.3f" +
                                        "%nVale Combustivel: R$ %.5f" +
                                        "%nVale Multibeneficios: R$ %4f" +
                                        "%nVale Refeição: R$ %.2f", va, vc, vr, multibeneficios);
                            }

                            // Inicialização loop do programa
                            while (sair) {

                                // Inicialização loop do administrador. Não permite opções inválidas
                                while (administrador) {
                                    System.out.printf("%n-------------------------------" +
                                            "%n5 - Resetar programa" +
                                            "%n6 - Trocar privilégio" +
                                            "%n7 - Acrescentar saldo" +
                                            "%n8 - Zerar saldos" +
                                            "%n9 - Ver saldo" +
                                            "%n0 - Encerrar programa" +
                                            "%nOpção escolhida: ");
                                    opcao = input.nextInt();

                                    // Reseta o programa desde a primeira tela
                                    if (opcao == 5) {
                                        System.out.printf("-------------------------------" +
                                                "%nReinicialização feita com sucesso!");
                                        administrador = false;
                                        resetar = true;
                                        sair = false;
                                        va = -1;
                                        vc = -1;
                                        vr = -1;
                                        multibeneficios = -1;
                                    }

                                    // Trocar o privilégio
                                    else if (opcao == 6) {
                                        sair = false;
                                        admpessoa = true;
                                        administrador = false;
                                    }

                                    // Acrescentar saldo escolhendo qual cartão. Não permite números negativos
                                    else if (opcao == 7) {
                                        System.out.printf("%n-----------------------------" +
                                                "%nEscolha qual cartão acrescentar saldo:" +
                                                "%n1 - Vale alimentação" +
                                                "%n2 - Vale transporte" +
                                                "%n3 - Vale refeição" +
                                                "%n4 - Vale Combustivel" +
                                                "%n5 - Multibeneficios" +
                                                "%nOpção desejada: ");
                                        opcao = input.nextInt();

                                        if (opcao == 1) {
                                            System.out.printf("%n-----------------------------" +
                                                    "%nVale alimentação escolhido. Saldo atual é de R$%.2f" +
                                                    "%nValor a acrescentar no vale alimentação: R$ ", va);
                                            valor = input.nextInt();
                                            while (valor < 0) {
                                                System.out.print("ERRO! Valor negativo. Favor inserir um valor positivo para acrescentar: R$ ");
                                                valor = input.nextInt();
                                            }
                                            va += valor;
                                            System.out.printf("Agora o saldo no vale alimentação é de: R$ %.2f", va);
                                        } else if (opcao == 2) {
                                            System.out.printf("%n-----------------------------" +
                                                    "%n%nVale combustivel escolhido. Saldo atual é de R$ %.2f" +
                                                    "%nValor a acrescentar no vale combustivel: R$", vc);
                                            valor = input.nextInt();
                                            while (valor < 0) {
                                                System.out.print("ERRO! Valor negativo. Favor inserir um valor positivo para acrescentar: R$ ");
                                                valor = input.nextInt();
                                            }
                                            vc += valor;
                                            System.out.printf("Agora o saldo no vale combustivel é de: R$ %.2f", vc);

                                        } else if (opcao == 4) {
                                            System.out.printf("%n-----------------------------" +
                                                    "%n%nMultibeneficios escolhido. Saldo atual é de R$ %.2f" +
                                                    "%nValor a acrescentar no Multibeneficios: R$", multibeneficios);
                                            valor = input.nextInt();
                                            while (valor < 0) {
                                                System.out.print("ERRO! Valor negativo. Favor inserir um valor positivo para acrescentar: R$ ");
                                                valor = input.nextInt();
                                            }
                                            multibeneficios += valor;
                                            System.out.printf("Agora o saldo no Multibeneficios é de: R$ %.2f", multibeneficios);

                                        } else if (opcao == 3) {
                                            System.out.printf("%nVale refeição. Saldo atual é de R$ %.2f" +
                                                    "%n-----------------------------" +
                                                    "%nValor a acrescentar no vale refeição: R$ ", vr);
                                            valor = input.nextInt();
                                            while (valor < 0) {
                                                System.out.print("ERRO! Valor negativo. Favor inserir um valor positivo para acrescentar: R$ ");
                                                valor = input.nextInt();
                                            }
                                            vr += valor;
                                            System.out.printf("Agora o saldo no vale refeição é de: R$ %.2f", vr);
                                        } else {
                                            System.out.printf("%n-------------------------------" +
                                                    "%nOpção inválida, tente novamente. ");
                                        }

                                    }

                                    // Zera os saldos sem reiniciar o programa
                                    else if (opcao == 8) {
                                        System.out.printf("-------------------------------" +
                                                "%nSaldos zerados com sucesso!");
                                        sair = false;
                                        va = 0;
                                        vc = 0;
                                        vr = 0;
                                        multibeneficios = 0;

                                    }

                                    // Mostra os saldos
                                    else if (opcao == 9) {
                                        System.out.printf("%n-------------------------------" +
                                                "%nOs saldos disponíves em seus cartões:" +
                                                "%nVale Alimentação: R$ %.2f" +
                                                "%nVale Transporte: R$ %.2f" +
                                                "%nVale Refeição: R$ %.2f" +
                                                "%nMultibeneficios R$ %.2f", va, vc, vr, multibeneficios);

                                    }

                                    // Encerra completamente o programa
                                    else if (opcao == 0) {
                                        System.out.printf("%n-------------------------------" +
                                                "%nObrigado por utilizar o programa. Até logo!");
                                        sair = false;
                                        resetar = false;
                                        administrador = false;
                                        break;
                                    }

                                    // Mensagem de erro: opção inválida
                                    else {
                                        System.out.printf("%n-------------------------------" +
                                                "%nOpção inválida, tente novamente. ");
                                    }
                                }

                                // Inicialização loop do usuário
                                while (sair) {
                                    System.out.printf("%n-------------------------------" +
                                            "%nEscolha qual cartão você deseja usar:" +
                                            "%n1 - Vale Alimentação" +
                                            "%n2 - Vale Combustivel" +
                                            "%n3 - Vale Refeição" +
                                            "%n4 - Multibeneficios" +
                                            "%n6 - Troca privilégio" +
                                            "%n9 - Ver saldos" +
                                            "%n0 - Encerrar programa" +
                                            "%n%nOpção escolhida: ");
                                    opcao = input.nextInt();

                                    // Debita do vale alimentação
                                    if (opcao == 1) {
                                        System.out.printf("%n-------------------------------" +
                                                "%nVale alimentação escolhido. Seu saldo atual é de R$ %.2f" +
                                                "%nDigite o valor da compra: R$ ", va);
                                        gasto = input.nextFloat();

                                        // Recusa valor negativo
                                        while (gasto < 0) {
                                            System.out.print("ERRO! Valor negativo. Favor inserir um valor positivo para debitar: R$ ");
                                            gasto = input.nextInt();
                                        }

                                        // Recusa valor maior do que o disponível
                                        if (gasto > va) {
                                            System.out.printf("%n-------------------------------" +
                                                    "%nERRO! Seu saldo não comporta esta compra" +
                                                    "%nSeu saldo no Vale Alimentação é de R$ %.2f", va);
                                        } else {
                                            va -= gasto;
                                            System.out.printf("%nSeu saldo no vale alimentação agora é de R$ %.2f", va);
                                        }
                                    }

                                    // Debita do vale Combustivel
                                    else if (opcao == 2) {
                                        System.out.printf("%n-------------------------------" +
                                                "%nVale Combustivel escolhido. Seu saldo atual é de R$ %.2f" +
                                                "%nDigite o valor da compra: R$ ", vc);
                                        gasto = input.nextFloat();

                                        // Recusa valor negativo
                                        while (gasto < 0) {
                                            System.out.print("ERRO! Valor negativo. Favor inserir um valor positivo para debitar: R$ ");
                                            gasto = input.nextInt();
                                        }

                                        // Recusa valor maior do que o disponível
                                        if (gasto > vc) {
                                            System.out.printf("%n-----------------------------" +
                                                    "%nERRO! Seu saldo não comporta esta compra" +
                                                    "%nSeu saldo no Vale Combustivel é de R$ %.2f ", vc);
                                        } else {
                                            vc -= gasto;
                                            System.out.printf("%n-----------------------------" +
                                                    "%nSeu saldo no vale combustivel agora é de R$ %.2f", vc);
                                        }
                                    }

                                    // Debita do vale refeição
                                    else if (opcao == 3) {
                                        System.out.printf("%n-------------------------------" +
                                                "%nVale refeição escolhido. Seu saldo atual é de R$ %.2f" +
                                                "%nDigite o valor da compra: R$ ", vr);
                                        gasto = input.nextFloat();

                                        // Recusa valor negativo
                                        while (gasto < 0) {
                                            System.out.print("ERRO! Valor negativo. Favor inserir um valor positivo para debitar: R$ ");
                                            gasto = input.nextInt();
                                        }

                                        // Recusa valor maior que o disponível
                                        if (gasto > vr) {
                                            System.out.printf("%n-----------------------------" +
                                                    "%nERRO! Seu saldo não comporta esta compra" +
                                                    "%nSeu saldo no Vale refeição é de R$ %.2f ", vr);
                                        } else {
                                            vr -= gasto;
                                            System.out.printf("%n-----------------------------" +
                                                    "%nSeu saldo no vale refeição agora é de R$ %.2f", vr);
                                        }

                                    }

                                    // Debita do multibeneficios
                                    else if (opcao == 4) {
                                        System.out.printf("%n-------------------------------" +
                                                "%n Multibeneficio escolhido. Seu saldo atual é de R$ %.2f" +
                                                "%nDigite o valor da compra: R$ ", multibeneficios);
                                        gasto = input.nextFloat();

                                        // Recusa valor negativo
                                        while (gasto < 0) {
                                            System.out.print("ERRO! Valor negativo. Favor inserir um valor positivo para debitar: R$ ");
                                            gasto = input.nextInt();
                                        }

                                        // Recusa valor maior que o disponível
                                        if (gasto > multibeneficios) {
                                            System.out.printf("%n-----------------------------" +
                                                    "%nERRO! Seu saldo não comporta esta compra" +
                                                    "%nSeu saldo no Multibeneficios é de R$ %.2f ", multibeneficios);
                                        } else {
                                            multibeneficios -= gasto;
                                            System.out.printf("%n-----------------------------" +
                                                    "%nSeu saldo no Multibeneficios agora é de R$ %.2f", multibeneficios);
                                        }

                                    }


                                    // Volta para a tela de escolher privilégio de usuário
                                    else if (opcao == 6) {
                                        sair = false;
                                        admpessoa = true;
                                    }

                                    // Mostrar os saldos na tela
                                    else if (opcao == 9) {
                                        System.out.printf("%n-------------------------------" +
                                                "%nOs saldos disponíves em seus cartões:" +
                                                "%nVale Alimentação: R$ %.2f" +
                                                "%nVale Combustivel: R$ %.2f" +
                                                "%nVale Refeição: R$ %.2f" +
                                                 "%nMultibeneficios: R$ %.2f", va, vc, vr, multibeneficios);

                                    }

                                    // Encerra completamente o programa
                                    else if (opcao == 0) {
                                        System.out.printf("%n-------------------------------" +
                                                "%nObrigado por utilizar o programa. Até logo!");
                                        sair = false;
                                        resetar = false;
                                        admpessoa = false;
                                    }

                                    // Mensagem de erro: opção inválida
                                    else {
                                        System.out.printf("%n-------------------------------" +
                                                "%nOpção inválida, tente novamente. ");
                                    }
                                }
                            }
                        }
                    }
                    input.close();
                }
            }
        }




