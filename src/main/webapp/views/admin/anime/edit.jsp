<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@include file="/common/taglib.jsp" %>
        <c:url var="APIurl" value="/api-admin-anime" />
        <c:url var="AnimeURL" value="/admin-anime" />
        <html>

        <head>
            <title>Chỉnh sửa bài viết</title>
        </head>

        <body>
            <div class="main-content">
                <div class="main-content-inner">
                    <div class="breadcrumbs" id="breadcrumbs">
                        <script type="text/javascript">
                            try { ace.settings.check('breadcrumbs', 'fixed') } catch (e) { }
                        </script>
                        <ul class="breadcrumb">
                            <li>
                                <i class="ace-icon fa fa-home home-icon"></i>
                                <a href="#">Trang chủ</a>
                            </li>
                            <li class="active">Chỉnh sửa bài viết</li>
                        </ul><!-- /.breadcrumb -->
                    </div>
                    <div class="page-content">
                        <div class="row">
                            <div class="col-xs-12">
                                <c:if test="${not empty messageResponse}">
                                    <div class="alert alert-${alert}">
                                        ${messageResponse}
                                    </div>
                                </c:if>
                                <form id="formSubmit">
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Thể loại</label>
                                        <div class="col-sm-9">
                                            <div class="checkbox-list">
                                                <c:forEach var="item" items="${categories}">
                                                    <label class="checkbox-inline">
                                                        <input type="checkbox" name="categoryCodes" value="${item.code}"
                                                            <c:forEach var="selected" items="${model.categoryModels}">
                                                        <c:if test="${selected.code == item.code}">
                                                            checked="checked"
                                                        </c:if>
                                                </c:forEach>
                                                />
                                                ${item.name}
                                                </label>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                    <br />
                                    <br />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Tiêu đề</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="title" name="title"
                                                value="${model.title}" />
                                        </div>
                                    </div>
                                    <br />
                                    <br />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Hình đại diện</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="thumbnail" name="thumbnail"
                                                value="${model.thumbnail}" />
                                        </div>
                                    </div>
                                    <br />
                                    <br />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Sao đánh giá</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="rating" name="rating"
                                                value="${model.rating}" />
                                        </div>
                                    </div>
                                    <br />
                                    <br />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Mô tả ngắn</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="shortDescription"
                                                name="shortDescription" value="${model.shortDescription}" />
                                        </div>
                                    </div>
                                    <br />
                                    <br />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Năm phát hành</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="releaseYear" name="releaseYear"
                                                value="${model.releaseYear}" />
                                        </div>
                                    </div>
                                    <br />
                                    <br />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Số tập</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="episodes" name="episodes"
                                                value="${model.episodes}" />
                                        </div>
                                    </div>
                                    <br />
                                    <br />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Tình trạng</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="status" name="status"
                                                value="${model.status}" />
                                        </div>
                                    </div>
                                    <br />
                                    <br />
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Quốc gia</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="country" name="country"
                                                value="${model.country}" />
                                        </div>
                                    </div>
                                    <br />
                                    <br />

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">Nội dung</label>
                                        <div class="col-sm-9">
                                            <textarea class="form-control" id="content" name="content"
                                                style="min-height: 175px; resize: none;">${model.content}</textarea>
                                        </div>
                                    </div>
                                    <br />
                                    <br />

                                    <div class="form-group col-sm-12"
                                        style="display:flex; justify-content:space-between;">
                                        <c:if test="${not empty model.id}">
                                            <input type="button" class="btn btn-white btn-warning btn-bold"
                                                value="Cập nhật bài viết" id="btnAddOrUpdateNew" />
                                        </c:if>
                                        <c:if test="${empty model.id}">
                                            <input type="button" class="btn btn-white btn-warning btn-bold"
                                                value="Thêm bài viết" id="btnAddOrUpdateNew" />
                                        </c:if>
                                        <a href="${AnimeURL}?type=list&maxPageItem=6&page=1" class="btn btn-default btn-bold">Thoát</a>
                                    </div>


                                    <input type="hidden" value="${model.id}" id="id" name="id" />
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <script>
                $('#btnAddOrUpdateNew').click(function (e) {
                    e.preventDefault();
                    var data = {};
                    var formData = $('#formSubmit').serializeArray();
                    $.each(formData, function (i, v) {
                        if (v.name === "categoryCodes") {
                            if (!data.categoryCodes) data.categoryCodes = [];
                            data.categoryCodes.push(v.value);
                        } else {
                            data["" + v.name + ""] = v.value;
                        }

                    });
                    var id = $('#id').val();
                    if (id) {
                        updateAnime(data);
                    } else {
                        addAnime(data);
                    }
                })
                function addAnime(data) {
                    $.ajax({
                        url: '${APIurl}',
                        type: 'POST',
                        contentType: 'application/json',
                        data: JSON.stringify(data),
                        dataType: 'json',
                        success: function (result) {
                            window.location.href = "${NewURL}?type=edit&id=" + result.id + "&message=insert_success";
                        },
                        error: function (error) {
                            window.location.href = "${NewURL}?type=list&maxPageItem=6&page=1&message=error_system";
                        }
                    });
                }
                function updateAnime(data) {
                    $.ajax({
                        url: '${APIurl}',
                        type: 'PUT',
                        contentType: 'application/json',
                        data: JSON.stringify(data),
                        dataType: 'json',
                        success: function (result) {
                            window.location.href = "${NewURL}?type=edit&id=" + result.id + "&message=update_success";
                        },
                        error: function (error) {
                            window.location.href = "${NewURL}?type=list&maxPageItem=6&page=1&message=error_system";
                        }
                    });
                }
            </script>
        </body>

        </html>