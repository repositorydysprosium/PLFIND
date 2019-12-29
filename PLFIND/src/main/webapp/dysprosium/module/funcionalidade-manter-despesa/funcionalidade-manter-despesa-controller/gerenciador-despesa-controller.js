var gerenciadorDespesaModule = angular.module('gerenciadorDespesaModule', []);

gerenciadorDespesaModule.controller('gerenciadorDespesaController', function($scope, $http) {

		function initializer() {
			$scope.recuperarFontePagamento();
			$scope.recuperarCanalPagamento();
			$scope.recuperarResponsavelPagamento();
			$scope.despesaModel.is_item_unico = "true";
			$scope.despesaModel.is_forma_pagamento_unico = "true";
			$scope.despesaModel.quantidade_produto_servico = 1;
			$scope.despesaModel.fonte_pagamento = null;
			$scope.despesaModel.canal_pagamento = null;
			$scope.despesaModel.responsavel_pagamento = null;
			toastr.options.progressBar = true;
			toastr.options.positionClass = 'toast-top-right';
			toastr.options.timeOut = '10000';
		};

		var URL_FONTE_PAGAMENTO = "http://localhost:8080/PLFIND-1.0.0.0-SNAPSHOT/PLFIND/fontePagamentoResource";
		var URL_CANAL_PAGAMENTO = "http://localhost:8080/PLFIND-1.0.0.0-SNAPSHOT/PLFIND/canalPagamentoResource";
		var URL_RESPONSAVEL_PAGAMENTO = "http://localhost:8080/PLFIND-1.0.0.0-SNAPSHOT/PLFIND/responsavelPagamentoResource";

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
				$scope.despesaVariavelList.push(despesaModel);
				$scope.clearDespesModelAll();
				toastr.success('Dados cadastrados com Sucesso!', 'Sucesso', {timeOut: 5000})
			}
		};

		$scope.cadastrarProdutoServico = function(despesaModel) {
			if(isValidaDespesaVariavel(despesaModel)) {
				produtoServicoModel.produtoServico = despesaModel.produto_servico;
				produtoServicoModel.valorProdutoServico = despesaModel.valor_despesa;
				$scope.produtoServicoList.push(angular.copy(produtoServicoModel));
				clearProdutoServico();
			}
		};

		$scope.cadastrarFormaPagamento = function(despesaModel) {
			formaPagamentoModel.fontePagamento = despesaModel.fonte_pagamento;
			formaPagamentoModel.canalPagamento = despesaModel.canal_pagamento;
			formaPagamentoModel.responsavelPagamento = despesaModel.responsavel_pagamento;
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
				if (despesaModel.is_item_unico == "true") {
					$scope.isItemUnicoFlag = false;
				} else {
					$scope.isItemUnicoFlag = true;
				}
			}
		};

		$scope.verificarFormaPagamentoUnico = function(despesaModel) {
			if(despesaModel != undefined) {
				if (despesaModel.is_forma_pagamento_unico == "true") {
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
			if(despesaModel.data_despesa == null || despesaModel.data_despesa == undefined || despesaModel.data_despesa == "") {
				data_despesa_.className = "form-group has-danger";
				$scope.isCamposDataDespesaInvalidoFlag = true;
				return false;
			} else {
				data_despesa_.className = "form-group";
				$scope.isCamposDataDespesaInvalidoFlag = false;
			}
			return true;
		}

		function isCampoProdutoServicoValid(despesaModel) {
			if(despesaModel.produto_servico == null || despesaModel.produto_servico == undefined || despesaModel.produto_servico == "") {
				produto_servico_.className = "form-group has-danger";
				$scope.isCampoProdutoServicoInvalidoFlag = true;
				return false;
			} else {
				produto_servico_.className = "form-group";
				$scope.isCampoProdutoServicoInvalidoFlag = false;
			}
			return true;
		}

		function isCampoValorDespesaValid(despesaModel) {
			if(despesaModel.valor_despesa == null || despesaModel.valor_despesa == undefined || despesaModel.valor_despesa == "") {
				valor_despesa_.className = "form-group has-danger";
				$scope.isCampoValorDespesaInvalidoFlag = true;
				return false;
			} else {
				valor_despesa_.className = "form-group";
				$scope.isCampoValorDespesaInvalidoFlag = false;
			}
			return true;
		}

		function isCampoQuantidadeProdutoServicoValid(despesaModel) {
			if(despesaModel.quantidade_produto_servico == null || despesaModel.quantidade_produto_servico == undefined || despesaModel.quantidade_produto_servico == "") {
				quantidade_produto_servico_.className = "form-group has-danger text-danger";
				$scope.isCampoQuantidadeProdutoServicoInvalidoFlag = true;
				return false;
			} else {
				quantidade_produto_servico_.className = "form-group";
				$scope.isCampoQuantidadeProdutoServicoInvalidoFlag = false;
			}
			return true;
		}

		function isCampoFontePagamentoValid(despesaModel) {
			if(despesaModel.fonte_pagamento == null) {
				fonte_pagamento_.className = "form-group has-danger text-danger";
				$scope.isCampoFontePagamentoInvalidoFlag = true;
				return false;
			} else {
				fonte_pagamento_.className = "form-group";
				$scope.isCampoFontePagamentoInvalidoFlag = false;
			}
			return true;
		}

		function isCampoCanalPagamentoValid(despesaModel) {
			if(despesaModel.canal_pagamento == null) {
				canal_pagamento_.className = "form-group has-danger text-danger";
				$scope.isCampoCanalPagamentoInvalidoFlag = true;
				return false;
			} else {
				canal_pagamento_.className = "form-group";
				$scope.isCampoCanalPagamentoInvalidoFlag = false;
			}
			return true;
		}

		function isCampoResponsavelPagamentoValid(despesaModel) {
			if(despesaModel.responsavel_pagamento == null) {
				responsavel_pagamento_.className = "form-group has-danger text-danger";
				$scope.isCampoResponsavelPagamentoInvalidoFlag = true;
				return false;
			} else {
				responsavel_pagamento_.className = "form-group";
				$scope.isCampoResponsavelPagamentoInvalidoFlag = false;
			}
			return true;
		}

		$scope.clearDespesModelAll = function() {
			$scope.despesaModel = {
				is_item_unico: "true",
				quantidade_item: 1,
				is_forma_pagamento_unico: "true",
				fonte_pagamento: null,
				canal_pagamento: null,
				responsavel_pagamento: null,
			};
			$scope.produtoServicoList = [];
			$scope.formaPagamentoList = [];
			$scope.isItemUnicoFlag = false;
			$scope.isFormaPagamentoUnicoFlag = false;

			$scope.despesaModel.quantidade_produto_servico = 1;

			favorecido_.className = "form-group";
			$scope.isCamposFavorecidoInvalidoFlag = false;

			data_despesa_.className = "form-group";
			$scope.isCamposDataDespesaInvalidoFlag = false;

			produto_servico_.className = "form-group";
			$scope.isCampoProdutoServicoInvalidoFlag = false;

			valor_despesa_.className = "form-group";
			$scope.isCampoValorDespesaInvalidoFlag = false;

			quantidade_produto_servico_.className = "form-group";
			$scope.isCampoQuantidadeProdutoServicoInvalidoFlag = false;

			fonte_pagamento_.className = "form-group";
			$scope.isCampoFontePagamentoInvalidoFlag = false;

			canal_pagamento_.className = "form-group";
			$scope.isCampoCanalPagamentoInvalidoFlag = false;

			responsavel_pagamento_.className = "form-group";
			$scope.isCampoResponsavelPagamentoInvalidoFlag = false;
		};

		function clearProdutoServico() {
			$scope.despesaModel.produto_servico = null;
			$scope.despesaModel.valor_despesa = null;
		};

		function clearFormaPagamento() {
			$scope.despesaModel.fonte_pagamento = null;
			$scope.despesaModel.canal_pagamento = null;
			$scope.despesaModel.responsavel_pagamento = null;
		};

		initializer();

});
