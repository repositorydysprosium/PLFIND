var gerenciadorDespesaModule = angular.module('gerenciadorDespesaModule', []);

gerenciadorDespesaModule.controller('gerenciadorDespesaController', function($scope, $http) {

		function initializer() {
			$scope.recuperarFavorecido();
			$scope.recuperarFontePagamento();
			$scope.recuperarCanalPagamento();
			$scope.recuperarResponsavelPagamento();
			$scope.despesaModel.isItemUnico = "true";
			$scope.despesaModel.isFormaPagamentoUnico = "true";
			$scope.despesaModel.fontePagamento = null;
			$scope.despesaModel.canalPagamento = null;
			$scope.produtoServicoModel = null;
			toastr.options.progressBar = true;
			toastr.options.positionClass = 'toast-top-right';
			toastr.options.timeOut = '10000';
		};

		var URL_FAVORECIDO_FIND_ALL = "http://localhost:8180/PLFIND-1.0.0.0-SNAPSHOT/PLFIND/favorecidoResource/findAll";
		var URL_FAVORECIDO_PERSIST = "http://localhost:8180/PLFIND-1.0.0.0-SNAPSHOT/PLFIND/favorecidoResource/persist";
		
		var URL_FONTE_PAGAMENTO = "http://localhost:8180/PLFIND-1.0.0.0-SNAPSHOT/PLFIND/fontePagamentoResource";
		var URL_FONTE_PAGAMENTO_PERSIST = "http://localhost:8180/PLFIND-1.0.0.0-SNAPSHOT/PLFIND/fontePagamentoResource/persist";
		
		var URL_CANAL_PAGAMENTO = "http://localhost:8180/PLFIND-1.0.0.0-SNAPSHOT/PLFIND/canalPagamentoResource/findAll";
		var URL_CANAL_PAGAMENTO_PERSIST = "http://localhost:8180/PLFIND-1.0.0.0-SNAPSHOT/PLFIND/canalPagamentoResource/persist";
		
		var URL_RESPONSAVEL_PAGAMENTO = "http://localhost:8180/PLFIND-1.0.0.0-SNAPSHOT/PLFIND/responsavelPagamentoResource";
		var URL_RESPONSAVEL_PAGAMENTO_PERSIST = "http://localhost:8180/PLFIND-1.0.0.0-SNAPSHOT/PLFIND/responsavelPagamentoResource/persist";
		
		var URL_DESPESA_VARIAVEL_FIND_ALL = "http://localhost:8180/PLFIND-1.0.0.0-SNAPSHOT/PLFIND/despesaVariavelResource/findAll";
		var URL_DESPESA_VARIAVEL_PERSIST = "http://localhost:8180/PLFIND-1.0.0.0-SNAPSHOT/PLFIND/despesaVariavelResource/persist";

		$scope.despesaModel = {};
		
		$scope.favorecidoList = [];
		$scope.produtoServicoList = [];
		$scope.formaPagamentoList = [];
		$scope.fontePagamentoList = [];
		$scope.canalPagamentoList = [];
		$scope.responsavelPagamentoList = [];
		$scope.despesaVariavelList = [];

		$scope.isItemUnicoFlag = false;
		$scope.isFormaPagamentoUnicoFlag = false;
		$scope.isCamposFavorecidoInvalidoFlag = false;
		$scope.isCamposDataDespesaInvalidoFlag = false;
		$scope.isCampoProdutoServicoInvalidoFlag = false;
		$scope.isCampoValorDespesaInvalidoFlag = false;
		$scope.isCampoFontePagamentoInvalidoFlag = false;
		$scope.isCampoCanalPagamentoInvalidoFlag = false;
		$scope.isCampoResponsavelPagamentoInvalidoFlag = false;
		$scope.isCampoQuantidadeProdutoServicoInvalidoFlag = false;

		var produtoServicoModel = {
			codigo: null,
			quantidadeProdutoServico: null,
			valorProdutoServico: null,
		};

		var formaPagamentoModel = {
			codigo: null,
			fontePagamento: null,
			canalPagamento: null,
			responsavelPagamento: null,
		};
		
		$scope.persist = function(despesaModel, produtoServicoModel) {
			console.log(despesaModel);
			
			if($scope.produtoServicoList.length != 0) {
				despesaModel.produtoServicoDomainList = $scope.produtoServicoList;
			} else {
				despesaModel.produtoServicoDomainList = [];
				despesaModel.produtoServicoDomainList.push(produtoServicoModel);
			}
			
			if(isValidaDespesaVariavel(despesaModel, produtoServicoModel)) {
				$http.post(URL_DESPESA_VARIAVEL_PERSIST, despesaModel).then(function(response) {
					$scope.despesaVariavelList.push(response.data);
					$scope.clearDespesModelAll();
				}, function(responseError) {
					return toastr.error('Não foi possível cadastrar a Despesa Variável! ' + responseError.data + "'", 'Erro do Sistema', {timeOut: 10000});
				});
			}
			return toastr.success('Dados cadastrados com Sucesso!', 'Sucesso', {timeOut: 5000});
		};
		
		$scope.cadastrarProdutoServico = function(produtoServicoModel) {
//			if(isValidaDespesaVariavel(produtoServicoModel) && verificarProdutoServicoDuplicado(produtoServicoModel)) {
//				produtoServicoModel.produtoServico = produtoServicoModel;
//				produtoServicoModel.valorProdutoServico = despesaModel.valorProdutoServico;
//				if(produtoServicoModel.quantidadeProdutoServico != 1) {
//					produtoServicoModel.valorProdutoServico = calcularValorTotalProdutoServico(produtoServicoModel.valorProdutoServico);
//					console.log(produtoServicoModel.valorProdutoServico);
//				}
				$scope.produtoServicoList.push(angular.copy(produtoServicoModel));
				clearProdutoServico();
//			} else {
//				toastr.error('Não foi possivel cadastrar o Produto ou Serviço', 'Erro', {timeOut: 5000});
//			}
		};

		$scope.recuperarFavorecido = function() {
			$http.get(URL_FAVORECIDO_FIND_ALL).then(function(response) {
				$scope.favorecidoList = response.data;
			}, function(responseError) {
				toastr.error('Serviço de recuperação do Favorecido não encontrado!', 'Erro do Sistema', {timeOut: 10000});
			});
		};
		
		$scope.recuperarFontePagamento = function() {
			$http.get(URL_FONTE_PAGAMENTO).then(function(response) {
				$scope.fontePagamentoList = response.data;
			}, function(responseError) {
				toastr.error('Serviço de recuperação da Fonte do Pagamento não encontrado!', 'Erro do Sistema', {timeOut: 10000});
			});
		};

		$scope.recuperarCanalPagamento = function() {
			$http.get(URL_CANAL_PAGAMENTO).then(function(response) {
				$scope.canalPagamentoList = response.data;
			}, function(responseError) {
				toastr.error('Serviço de recuperação da Canal do Pagamento não encontrado!', 'Erro do Sistema', {timeOut: 10000});
			});
		};

		$scope.recuperarResponsavelPagamento = function() {
			$http.get(URL_RESPONSAVEL_PAGAMENTO).then(function(response) {
				$scope.responsavelPagamentoList = response.data;
			}, function(responseError) {
				toastr.error('Serviço de recuperação do Responsável pelo Pagamento não encontrado!', 'Erro do Sistema', {timeOut: 10000});
			});
		};
		
		$scope.cadastrarFavorecido = function(despesaModel) {
			console.log(despesaModel);
//			if(isValidaDespesaVariavel(despesaModel)) {
				$http.post(URL_FAVORECIDO_PERSIST, despesaModel.favorecido).then(function(response) {
					$scope.favorecidoList.push(response.data);
					$scope.despesaModel.favorecido.codigo = response.data.codigo;
//					$scope.clearDespesModelAll();
					toastr.success('Favorecido cadastrado com Sucesso!', 'Sucesso', {timeOut: 5000});
				}, function(responseError) {
					toastr.error('Não foi possível cadastrar o novo Favorecido! ' + responseError.data + "'", 'Erro do Sistema', {timeOut: 10000});
				});
//			}
		};
		
		$scope.cadastrarCanalPagamento = function(despesaModel) {
			console.log(despesaModel);
//			if(isValidaDespesaVariavel(despesaModel)) {
				$http.post(URL_CANAL_PAGAMENTO_PERSIST, despesaModel.canalPagamento).then(function(response) {
					$scope.canalPagamentoList.push(response.data);
					$scope.despesaModel.canalPagamento.codigo = response.data.codigo;
//					$scope.clearDespesModelAll();
					toastr.success('Canal de Pagamento cadastrado com Sucesso!', 'Sucesso', {timeOut: 5000});
				}, function(responseError) {
					toastr.error('Não foi possível cadastrar o novo Canal de Pagamento! ' + responseError.data + "'", 'Erro do Sistema', {timeOut: 10000});
				});
//			}
		};
		
		$scope.cadastrarResponsavelPagamento = function(despesaModel) {
			console.log(despesaModel);
//			if(isValidaDespesaVariavel(despesaModel)) {
				$http.post(URL_RESPONSAVEL_PAGAMENTO_PERSIST, despesaModel.responsavelPagamento).then(function(response) {
					$scope.responsavelPagamentoList.push(response.data);
					$scope.despesaModel.responsavelPagamento.codigo = response.data.codigo;
//					$scope.clearDespesModelAll();
					toastr.success('Responsável pelo Pagamento cadastrado com Sucesso!', 'Sucesso', {timeOut: 5000});
				}, function(responseError) {
					toastr.error('Não foi possível cadastrar o Responsável pelo Pagamento! ' + responseError.data + "'", 'Erro do Sistema', {timeOut: 10000});
				});
//			}
		};
		
		$scope.cadastrarFontePagamento = function(despesaModel) {
			console.log(despesaModel);
//			if(isValidaDespesaVariavel(despesaModel)) {
				$http.post(URL_FONTE_PAGAMENTO_PERSIST, despesaModel.fontePagamento).then(function(response) {
					$scope.fontePagamentoList.push(response.data);
					$scope.despesaModel.fontePagamento.codigo = response.data.codigo;
//					$scope.clearDespesModelAll();
					toastr.success('Fonte de Pagamento cadastrado com Sucesso!', 'Sucesso', {timeOut: 5000});
				}, function(responseError) {
					toastr.error('Não foi possível cadastrar a nova Fonte de Pagamento! ' + responseError.data + "'", 'Erro do Sistema', {timeOut: 10000});
				});
//			}
		};
		
		function formatarData(data) {
			var dataFormatada = new Date(data);
			return dataFormatada;
		};
		
		$scope.mascaraDataFormatoDDMMAAAA = function (dataParameter) {
			var dataFormatada = dataParameter;
			if (dataFormatada.length == 2) {
				dataFormatada = dataFormatada + '/';
				$scope.despesaModel.dataDespesa = dataFormatada;
				return true;
			}
			if (dataFormatada.length == 5) {
				dataFormatada = dataFormatada + '/';
				$scope.despesaModel.dataDespesa = dataFormatada;
				return true;
			}
		};
		
//		function verificarProdutoServicoDuplicado(produtoServico) {
//			if($scope.produtoServicoList.length > 0) {
//				for( let index = 0 ; index < $scope.produtoServicoList.length ; index++ ) {
//					var produtoServicoRetorno = $scope.produtoServicoList[index].produtoServico;
//					if (produtoServico.descricao === produtoServicoRetorno.descricao && 
//						produtoServicoRetorno.valorProdutoServico === produtoServicoRetorno.valorProdutoServico &&
//						produtoServicoRetorno.quantidadeProdutoServico === produtoServicoRetorno.quantidadeProdutoServico) {
//						toastr.error('Produto ou Serviço já cadastrado!', 'Dados Duplicados', {timeOut: 5000});
//						return false;
//					}
//				}
//			}
//			return true;
//		};
		
		function calcularValorTotalProdutoServico(despesaModel) {
			return despesaModel.valorProdutoServico * despesaModel.quantidadeProdutoServico;
		};

		$scope.cadastrarFormaPagamento = function(despesaModel) {
			formaPagamentoModel.fontePagamento = despesaModel.fontePagamento;
			formaPagamentoModel.canalPagamento = despesaModel.canalPagamento;
			formaPagamentoModel.responsavelPagamento = despesaModel.responsavelPagamento;
			$scope.formaPagamentoList.push(angular.copy(formaPagamentoModel));
			clearFormaPagamento();
		};

//		$scope.removeProdutoServico = function(produtoServicoModel) {
//			for( let index = 0 ; index < $scope.produtoServicoList.length ; index++ ) {
//				if (produtoServicoModel.produtoServico === $scope.produtoServicoList[index].produtoServico &&
//					produtoServicoModel.valorProdutoServico === $scope.produtoServicoList[index].valorProdutoServico) {
//					$scope.produtoServicoList.splice(index, 1);
//				}
//			}
//		};

		$scope.verificarItemUnico = function(despesaModel) {
			if(despesaModel != undefined) {
				if (despesaModel.isItemUnico == "true") {
					$scope.isItemUnicoFlag = false;
				} else {
					$scope.isItemUnicoFlag = true;
				}
			}
		};

		$scope.verificarFormaPagamentoUnico = function(despesaModel) {
			if(despesaModel != undefined) {
				if (despesaModel.isFormaPagamentoUnico == "true") {
					$scope.isFormaPagamentoUnicoFlag = false;
				} else {
					$scope.isFormaPagamentoUnicoFlag = true;
				}
			}
		};

		function isValidaDespesaVariavel(despesaModel, produtoServicoModel) {
			if(isCampoFavorecidoValid(despesaModel) && 
			   isCampoDataDespesaValid(despesaModel) &&
			   isCampoProdutoServicoValid(despesaModel) &&
			   isCampoValorDespesaValid(despesaModel, produtoServicoModel) &&
			   isCampoQuantidadeProdutoServicoValid(despesaModel, produtoServicoModel) &&
			   isCampoFontePagamentoValid(despesaModel) &&
			   isCampoCanalPagamentoValid(despesaModel) && 
			   isCampoResponsavelPagamentoValid(despesaModel)) {
				return true;
			}
			return false;
		};

		function isCampoFavorecidoValid(despesaModel) {
			if(despesaModel.favorecido == null || despesaModel.favorecido == undefined || despesaModel.favorecido == "") {
				favorecido_.className = "form-group has-danger";
				$scope.isCamposFavorecidoInvalidoFlag = true;
				return false;
			} else {
				favorecido_.className = "form-group";
				$scope.isCamposFavorecidoInvalidoFlag = false;
			}
			return true;
		}

		function isCampoDataDespesaValid(despesaModel) {
			if(despesaModel.dataDespesa == null || despesaModel.dataDespesa == undefined || despesaModel.dataDespesa == "") {
				dataDespesa_.className = "form-group has-danger";
				$scope.isCamposDataDespesaInvalidoFlag = true;
				return false;
			} else {
				dataDespesa_.className = "form-group";
				$scope.isCamposDataDespesaInvalidoFlag = false;
			}
			return true;
		}

		function isCampoProdutoServicoValid(despesaModel) {
			if(produtoServicoModel == null || produtoServicoModel == undefined || produtoServicoModel == "") {
				produtoServicoModel_.className = "form-group has-danger";
				$scope.isCampoProdutoServicoInvalidoFlag = true;
				return false;
			} else {
				produtoServicoModel_.className = "form-group";
				$scope.isCampoProdutoServicoInvalidoFlag = false;
			}
			return true;
		}

		function isCampoValorDespesaValid(despesaModel, produtoServicoModel) {
			if(!$scope.produtoServicoList.length > 0) {
				if(produtoServicoModel.valorProdutoServico == null || produtoServicoModel.valorProdutoServico == undefined || produtoServicoModel.valorProdutoServicoa == "") {
					valorProdutoServico_.className = "form-group has-danger";
					$scope.isCampoValorDespesaInvalidoFlag = true;
					return false;
				} else {
					valorProdutoServico_.className = "form-group";
					$scope.isCampoValorDespesaInvalidoFlag = false;
				}
			}
			return true;
		}

		function isCampoQuantidadeProdutoServicoValid(despesaModel, produtoServicoModel) {
			if(!$scope.produtoServicoList.length > 0) {
				if(produtoServicoModel.quantidadeProdutoServico == null || 
				   produtoServicoModel.quantidadeProdutoServico == undefined || 
				   produtoServicoModel.quantidadeProdutoServico == "") {
					quantidadeProdutoServico_.className = "form-group has-danger text-danger";
					$scope.isCampoQuantidadeProdutoServicoInvalidoFlag = true;
					return false;
				} else {
					quantidadeProdutoServico_.className = "form-group";
					$scope.isCampoQuantidadeProdutoServicoInvalidoFlag = false;
				}
			}
			return true;
		}

		function isCampoFontePagamentoValid(despesaModel) {
			if(despesaModel.fontePagamento == null) {
				fontePagamento_.className = "form-group has-danger text-danger";
				$scope.isCampoFontePagamentoInvalidoFlag = true;
				return false;
			} else {
				fontePagamento_.className = "form-group";
				$scope.isCampoFontePagamentoInvalidoFlag = false;
			}
			return true;
		}

		function isCampoCanalPagamentoValid(despesaModel) {
			if(despesaModel.canalPagamento == null) {
				canalPagamento_.className = "form-group has-danger text-danger";
				$scope.isCampoCanalPagamentoInvalidoFlag = true;
				return false;
			} else {
				canalPagamento_.className = "form-group";
				$scope.isCampoCanalPagamentoInvalidoFlag = false;
			}fontePagamento
			return true;
		}

		function isCampoResponsavelPagamentoValid(despesaModel) {
			if(despesaModel.responsavelPagamento == null) {
				responsavelPagamento_.className = "form-group has-danger text-danger";
				$scope.isCampoResponsavelPagamentoInvalidoFlag = true;
				return false;
			} else {
				responsavelPagamento_.className = "form-group";
				$scope.isCampoResponsavelPagamentoInvalidoFlag = false;
			}
			return true;
		}

		$scope.clearDespesModelAll = function() {
			$scope.despesaModel = {
				isItemUnico: "true",
				isFormaPagamentoUnico: "true",
				fontePagamento: null,
				canalPagamento: null,
				responsavelPagamento: null
			};
			
			$scope.produtoServicoModel = {
				valorProdutoServico: null,
				descricao: null,
				quantidadeProdutoServico: null
			};
			
			$scope.despesaModel.produtoServicoDomainList = [];
			
			$scope.produtoServicoList = [];
			$scope.formaPagamentoList = [];
			$scope.isItemUnicoFlag = false;
			$scope.isFormaPagamentoUnicoFlag = false;

			favorecido_.className = "form-group";
			$scope.isCamposFavorecidoInvalidoFlag = false;

			dataDespesa_.className = "form-group";
			$scope.isCamposDataDespesaInvalidoFlag = false;

			produtoServico_.className = "form-group";
			$scope.isCampoProdutoServicoInvalidoFlag = false;

			valorProdutoServico_.className = "form-group";
			$scope.isCampoValorDespesaInvalidoFlag = false;

			quantidadeProdutoServico_.className = "form-group";
			$scope.isCampoQuantidadeProdutoServicoInvalidoFlag = false;

			fontePagamento_.className = "form-group";
			$scope.isCampoFontePagamentoInvalidoFlag = false;

			canalPagamento_.className = "form-group";
			$scope.isCampoCanalPagamentoInvalidoFlag = false;

			responsavelPagamento_.className = "form-group";
			$scope.isCampoResponsavelPagamentoInvalidoFlag = false;
		};

		function clearProdutoServico() {
			$scope.produtoServicoModel = null;
		};

		function clearFormaPagamento() {
			$scope.despesaModel.fontePagamento = null;
			$scope.despesaModel.canalPagamento = null;
			$scope.despesaModel.responsavelPagamento = null;
		};

		initializer();

});
