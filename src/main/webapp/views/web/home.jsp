<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@include file="/common/taglib.jsp" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
      <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
      <html>

      <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chủ</title>
      </head>

      <body>
        <form action="<c:url value='/trang-chu'/>" id="formSubmit" method="get">
          <div class="row">
            <div class="col-lg-3">
              <h1 class="my-4">Shop Name</h1>
              <div class="category-list">
                <c:forEach var="item" items="${categories}">
                  <label class="checkbox-inline d-block">
                    <input type="checkbox" name="categoryCodes" value="${item.code}" <c:if
                      test="${fn:contains(selectedCategories, item.code)}">checked</c:if>>
                    ${item.name}
                  </label>
                </c:forEach>
              </div>
              <button type="submit" id="filterBtn" class="btn btn-success mt-2">
                <i class="fa fa-filter"></i> Lọc danh sách
              </button>
            </div>
            <!-- /.col-lg-3 -->

            <div class="col-lg-9">

              <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
                <ol class="carousel-indicators">
                  <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                  <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                  <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner" role="listbox">
                  <div class="carousel-item active">
                    <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="First slide">
                  </div>
                  <div class="carousel-item">
                    <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Second slide">
                  </div>
                  <div class="carousel-item">
                    <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Third slide">
                  </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                  <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                  <span class="carousel-control-next-icon" aria-hidden="true"></span>
                  <span class="sr-only">Next</span>
                </a>
              </div>

              <div class="row">
                <c:forEach var="item" items="${model.listResult}">
                  <div class="col-lg-4 col-md-4 mb-4">
                    <div class="card h-100 shadow-sm border-0">
                      <c:url var="itemURL" value="/item-anime">
                        <c:param name="id" value="${item.id}" />
                      </c:url>
                      <a href="${itemURL}">
                        <img class="card-img-top img-fluid" src="${item.thumbnail}" alt="${item.title}"
                          style="height:250px; object-fit:cover;">
                      </a>
                      <div class="card-body text-center d-flex flex-column justify-content-between">
                        <h5 class="card-title mb-2">
                          <a href="${itemURL}" class="text-dark fw-bold">${item.title}</a>
                        </h5>
                        <p class="card-text text-muted small"
                          style="height: 60px; overflow: hidden; text-overflow: ellipsis;">
                          ${item.shortDescription}
                        </p>
                        <div class="mb-2">
                          <c:forEach begin="1" end="5" var="star">
                            <c:choose>
                              <c:when test="${star <= item.rating}">
                                <i class="bi bi-star-fill text-warning"></i>
                              </c:when>
                              <c:otherwise>
                                <i class="bi bi-star text-warning"></i>
                              </c:otherwise>
                            </c:choose>
                          </c:forEach>
                        </div>
                      </div>
                      <div class="card-footer bg-transparent border-0 text-center">
                        <a href="${itemURL}" class="btn btn-outline-primary btn-sm">Xem chi tiết</a>
                      </div>
                    </div>
                  </div>
                </c:forEach>
              </div>
              <!-- /.row -->
              <ul class="pagination" id="pagination"></ul>

              <input type="hidden" id="page" name="page" value="1" />
              <input type="hidden" id="maxPageItem" name="maxPageItem" value="6" />
              <input type="hidden" id="sortName" name="sortName" value="title" />
              <input type="hidden" id="sortBy" name="sortBy" value="desc" />
              <input type="hidden" id="type" name="type" value="list" />
            </div>
            <!-- /.col-lg-9 -->

          </div>
        </form>
        <!-- /.row -->
        <script>
          var totalPages = ${ model.totalPage };
          var currentPage = ${ model.page };
          var totalItem = ${ model.totalItem }
          var limit = 6;
          console.log("totalPages=", totalPages, "currentPage=", currentPage);
          $(function () {
            window.pagObj = $('#pagination').twbsPagination({
              totalPages: totalPages,
              visiblePages: 10,
              startPage: currentPage,
              onPageClick: function (event, page) {
                if (currentPage != page) {
                  $('#maxPageItem').val(limit);
                  $('#page').val(page);
                  $('#sortName').val('title');
                  $('#sortBy').val('desc');
                  $('#type').val('list');
                  $('#formSubmit').submit();
                }
              }
            });
          });

        </script>
      </body>

      </html>