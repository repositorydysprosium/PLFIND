var gerenciadorDespesaModule = angular.module('gerenciadorDespesaModule', []);

gerenciadorDespesaModule.controller('gerenciadorDespesaController', function($scope, $http) {

		function initializer() {
			$scope.recuperarFavorecido();
			$scope.recuperarFontePagamento();
			$scope.recuperarCanalPagamento();
			$scope.recuperarResponsavelPagamento();
			$scope.despesaModel.isItemUnico = "true";
			$scope.despesaModel.isFormaPagamentoUnico = "true";
			$scope.despesaModel.quantidadeProdutoServico = 1;
			$scope.despesaModel.fontePagamento = null;
			$scope.despesaModel.canalPagamento = null;
			$scope.despesaModel.produtoServico = null;
			$scope.despesaModel.responsavelPagamento = null;
			toastr.options.progressBar = true;
			toastr.options.positionClass = 'toast-top-right';
			toastr.options.timeOut = '10000';
		};

		var URL_FAVORECIDO_FIND_ALL = "http://localhost:8080/PLFIND-1.0.0.0-SNAPSHOT/PLFIND/favorecidoResource/findAll";
		var URL_FONTE_PAGAMENTO = "http://localhost:8080/PLFIND-1.0.0.0-SNAPSHOT/PLFIND/fontePagamentoResource";
		var URL_CANAL_PAGAMENTO = "http://localhost:8080/PLFIND-1.0.0.0-SNAPSHOT/PLFIND/canalPagamentoResource/findAll";
		var URL_RESPONSAVEL_PAGAMENTO = "http://localhost:8080/PLFIND-1.0.0.0-SNAPSHOT/PLFIND/responsavelPagamentoResource";
		var URL_DESPESA_VARIAVEL_FIND_ALL = "http://localhost:8080/PLFIND-1.0.0.0-SNAPSHOT/PLFIND/despesaVariavelResource/findAll";
		var URL_DESPESA_VARIAVEL_PERSIST = "http://localhost:8080/PLFIND-1.0.0.0-SNAPSHOT/PLFIND/despesaVariavelResource/persist";

		$scope.favorecidoList = [];
		
		$scope.produtoServicoList = [];

		$scope.formaPagamentoList = [];

		$scope.fontePagamentoList = [];

		$scope.canalPagamentoList = [];

		$scope.responsavelPagamentoList = [];

		$scope.despesaVariavelList = [];

		$scope.despesaModel = {};

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
			produtoServico: null,
			valorProdutoServico: null,
		};

		var formaPagamentoModel = {
			codigo: null,
			fontePagamento: null,
			canalPagamento: null,
			responsavelPagamento: null,
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

		$scope.persist = function(despesaModel) {
			console.log(despesaModel);
			if(isValidaDespesaVariavel(despesaModel)) {
				despesaModel.dataDespesa = formatarData(despesaModel.dataDespesa);
				$http.post(URL_DESPESA_VARIAVEL_PERSIST, despesaModel).then(function(response) {
					$scope.despesaVariavelList.push(response.data);
					$scope.clearDespesModelAll();
					toastr.success('Dados cadastrados com Sucesso!', 'Sucesso', {timeOut: 5000});
				}, function(responseError) {
					toastr.error('Não foi possível cadastrar a Despesa Variável! ' + responseError.data + "'", 'Erro do Sistema', {timeOut: 10000});
				});
			}
		};
		
		function formatarData(data) {
			var dataFormatada = new Date(data);
			return dataFormatada;
		};

		$scope.cadastrarProdutoServico = function(despesaModel) {
			if(isValidaDespesaVariavel(despesaModel)) {
				produtoServicoModel.produtoServico = despesaModel.produtoServico;
				produtoServicoModel.valorProdutoServico = despesaModel.valorDespesa;
				$scope.produtoServicoList.push(angular.copy(produtoServicoModel));
				clearProdutoServico();
			}
		};

		$scope.cadastrarFormaPagamento = function(despesaModel) {
			formaPagamentoModel.fontePagamento = despesaModel.fontePagamento;
			formaPagamentoModel.canalPagamento = despesaModel.canalPagamento;
			formaPagamentoModel.responsavelPagamento = despesaModel.responsavelPagamento;
			$scope.formaPagamentoList.push(angular.copy(formaPagamentoModel));
			clearFormaPagamento();
		};

		$scope.removeProdutoServico = function(produtoServicoModel) {
			for( let index = 0 ; index < $scope.produtoServicoList.length ; index++ ) {
				if (produtoServicoModel.produtoServico === $scope.produtoServicoList[index].produtoServico &&
					produtoServicoModel.valorProdutoServico === $scope.produtoServicoList[index].valorProdutoServico) {
					$scope.produtoServicoList.splice(index, 1);
				}
			}
		};

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

		function isValidaDespesaVariavel(despesaModel) {
			if(isCampoFavorecidoValid(despesaModel) && 
			   isCampoDataDespesaValid(despesaModel) &&
			   isCampoProdutoServicoValid(despesaModel) &&
			   isCampoValorDespesaValid(despesaModel) &&
			   isCampoQuantidadeProdutoServicoValid(despesaModel) &&
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
			if(despesaModel.produtoServico == null || despesaModel.produtoServico == undefined || despesaModel.produtoServico == "") {
				produtoServico_.className = "form-group has-danger";
				$scope.isCampoProdutoServicoInvalidoFlag = true;
				return false;
			} else {
				produtoServico_.className = "form-group";
				$scope.isCampoProdutoServicoInvalidoFlag = false;
			}
			return true;
		}

		function isCampoValorDespesaValid(despesaModel) {
			if(despesaModel.valorDespesa == null || despesaModel.valorDespesa == undefined || despesaModel.valorDespesa == "") {
				valorDespesa_.className = "form-group has-danger";
				$scope.isCampoValorDespesaInvalidoFlag = true;
				return false;
			} else {
				valorDespesa_.className = "form-group";
				$scope.isCampoValorDespesaInvalidoFlag = false;
			}
			return true;
		}

		function isCampoQuantidadeProdutoServicoValid(despesaModel) {
			if(despesaModel.quantidadeProdutoServico == null || despesaModel.quantidadeProdutoServico == undefined || despesaModel.quantidadeProdutoServico == "") {
				quantidadeProdutoServico_.className = "form-group has-danger text-danger";
				$scope.isCampoQuantidadeProdutoServicoInvalidoFlag = true;
				return false;
			} else {
				quantidadeProdutoServico_.className = "form-group";
				$scope.isCampoQuantidadeProdutoServicoInvalidoFlag = false;
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
				quantidadeProdutoServico: 1,
				isFormaPagamentoUnico: "true",
				fontePagamento: null,
				canalPagamento: null,
				responsavelPagamento: null,
				produtoServico: null,
			};
			$scope.produtoServicoList = [];
			$scope.formaPagamentoList = [];
			$scope.isItemUnicoFlag = false;
			$scope.isFormaPagamentoUnicoFlag = false;

			$scope.despesaModel.quantidadeProdutoServico = 1;

			favorecido_.className = "form-group";
			$scope.isCamposFavorecidoInvalidoFlag = false;

			dataDespesa_.className = "form-group";
			$scope.isCamposDataDespesaInvalidoFlag = false;

			produtoServico_.className = "form-group";
			$scope.isCampoProdutoServicoInvalidoFlag = false;

			valorDespesa_.className = "form-group";
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
			$scope.despesaModel.produtoServico = null;
			$scope.despesaModel.valorDespesa = null;
		};

		function clearFormaPagamento() {
			$scope.despesaModel.fontePagamento = null;
			$scope.despesaModel.canalPagamento = null;
			$scope.despesaModel.responsavelPagamento = null;
		};

		initializer();

});
