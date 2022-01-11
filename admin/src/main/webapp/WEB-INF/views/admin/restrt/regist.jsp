<%@page import="com.koreait.matjip.domain.Category"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	List<Category> categoryList =(List)request.getAttribute("categoryList");
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Dashboard</title>
	
	<%@ include file="../../inc/head_link.jsp" %>
  <!-- summernote -->
  <link rel="stylesheet" href="/resources/admin/plugins/summernote/summernote-bs4.min.css">
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">

</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">

  <!-- Preloader -->
  <div class="preloader flex-column justify-content-center align-items-center">
    <img class="animation__shake" src="/resources/admin/dist/img/AdminLTELogo.png" alt="AdminLTELogo" height="60" width="60">
  </div>

  <!-- Navbar -->
  <%@ include file="../../inc/navbar.jsp" %>
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
  <%@ include file="../../inc/sidebar.jsp" %>  

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">Dashboard</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Dashboard v1</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <!-- Small boxes (Stat box) -->
        <div class="row">
        
          <!-- 카테고리 테이블 begin -->
          <div class="col-3">
              <div class="card">
              <div class="card-header">
                <h3 class="card-title">Expandable Table Tree</h3>
              </div>
              <!-- ./card-header -->
              <div class="card-body p-0">
                <table class="table table-hover">
                  <tbody>

					<%for(Category category  : categoryList){ %>	
                    <tr data-widget="expandable-table" aria-expanded="true">
                      <td>
                        <%if(category.getDepth()>0){%>
                        	<i class="expandable-table-caret fas fa-caret-right fa-fw" style="margin-left:<%=20*category.getDepth()%>px"></i>
                        <%}%>
                        <a href="javascript:selCategory('<%=category.getCategory_name() %>',  <%=category.getCategory_id() %>)"><%=category.getCategory_name() %></a>
                      </td>
                    </tr>
                    <%} %>
                    
                    <tr>
                      <td>
						<button type="button" class="btn btn-info" onClick="location.href='/admin/category/registform';">카테고리 등록</button>                      
                      </td>
                    </tr>
                    
                  </tbody>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
            </div>
          <!-- 카테고리 테이블 end -->
          
          <!-- 상품 등록폼 begin -->
          <div class="col-9">
            <div class="card card-info">
              <div class="card-header">
                <h3 class="card-title">Quick Example</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form name="form1" enctype="multipart/form-data">
                <div class="card-body">
                
                  <div class="form-group">
                    <select class="form-control" id="category_id" name="category.category_id">
                    	<option>좌측에서 카테고리 선택</option>
                    </select> 
                  </div>
                  <div class="form-group">
                    <input type="text" class="form-control" placeholder="상품명 입력.." name="restrt_name">
                  </div>
                  
                  <div class="form-group">
                    <input type="text" class="form-control" placeholder="가격 입력.." name="price">
                  </div>
                  
                  <div class="form-group">
                    <textarea id="introduce" placeholder="상품간략 소개" name="introduce">상품 간략 소개</textarea>
                  </div>
                  
                  <div class="form-group">
                    <textarea id="detail" name="detail">상품 상세 정보</textarea>
                  </div>
                  
                  <div class="form-group">
                  	<div id="preview"></div>
                  	
                    <div class="input-group">
                      <div class="custom-file">
                        <input type="file" class="custom-file-input" multiple name="imgFiles">
                        <label class="custom-file-label" for="exampleInputFile">Choose file</label>
                      </div>
                      <div class="input-group-append">
                        <span class="input-group-text">Upload</span>
                      </div>
                    </div>
                  </div>
                  
                  <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">Check me out</label>
                  </div>
                </div>
                <!-- /.card-body -->

                <div class="card-footer">
                  <button type="button" class="btn btn-info" id="bt_regist">등록</button>
                  <button type="button" class="btn btn-info" onClick="location.href='/admin/restrt/list';">목록</button>
                </div>
              </form>
            </div>
            </div>
          <!-- 상품 등록폼 end -->
            
            <!-- /.card -->
          </div>
        </div>
        
        <!-- /.row (main row) -->
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  
  <%@ include file="../../inc/footer.jsp" %>  
  

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<%@ include file="../../inc/bottom_link.jsp" %>

<!-- Summernote -->
<script src="/resources/admin/plugins/summernote/summernote-bs4.min.js"></script>

<!-- bs-custom-file-input 파일컴포넌트 커스터마이징 -->
<script src="/resources/admin/plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>

<script>
$(function () {
  bsCustomFileInput.init();
});
</script>
<script>
 $(function () {
    // Summernote
    $('#introduce').summernote();  
    $('#detail').summernote();  
    
    //이미지 미리보기 버튼 이벤트 
    
    
    $("input[name='imgFiles']").change(function(){
		preview2(this);		    	
    });
	/*
	document.querySelector("input[name='imgFiles']").addEventListener("change", function(){
		preview(this);		
	});
	*/
	
	$("#bt_regist").click(function(){
		regist();
	});
	
})

//select 컴포넌트에 선택한 카테고리 반영하기!!
function selCategory(category_name, category_id){
	var sel = document.querySelector("#category_id");
	sel.options[0].text=category_name; //사용자가 보게될 옵션의 제목 	
	sel.options[0].value=category_id; //사용자가 보게될 옵션의 값 	
}

function regist(){
	form1.action="/admin/restrt/regist";
	form1.method="post";
	form1.encoding="multipart/form-data";
	form1.submit();
}
 
//제이쿼리로도 처리해 본다
function preview2(obj){
	for(var i=0;i<obj.files.length;i++){		
		var reader = new FileReader();
		reader.onload=function(e){
		 $("#preview").append($("<img src='"+e.target.result+"' width='100px'>"));
		 
		}
		reader.readAsDataURL(obj.files[i]);
	}
}

//자바스크립트도 stream이 지원된다..
function preview(obj){
	console.log("이벤트를 발생시킨 컴포넌트는 ", obj);
	console.log("obj.files is ", obj.files);
	
	for(var i=0;i<obj.files.length;i++){
		//파일에 대한 접근방법을 알았으니, 지금부터는 실제 파일을 읽어와보자!! 그러기 위해서는 스트림 객체가 필요하다
		var reader = new FileReader();
		
		reader.onload=function(e){
			console.log("읽어들인 정보 e는 ", e);
			
			//div에 동적으로 img 돔을 생성하여 그 돔의 src속서에 e.target.result
			var img=document.createElement("img");
			img.src=e.target.result;
			img.style.width=100+"px";
			
			document.getElementById("preview").appendChild(img); //동적으로 이미지 돔을 div에 넣기!!
			
		}; //파일을 다 읽어들이면, 익명함수가 호출된다..
		
		
		reader.readAsDataURL(obj.files[i]); //파일 읽어들이기...
	}
}
</script>
</body>
</html>
