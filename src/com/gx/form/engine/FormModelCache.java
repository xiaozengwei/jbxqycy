package com.gx.form.engine;

import com.gx.form.engine.model.FormModel;

public interface FormModelCache {
    FormModel getFormModel(String id);

    void setFormModel(FormModel formModel);
}
